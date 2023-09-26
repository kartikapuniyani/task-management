package com.task.service.serviceImpl;

import com.task.co.TaskCO;
import com.task.entity.Task;
import com.task.repository.TaskRepository;
import com.task.service.TaskService;
import com.task.vo.AggregateVO;
import com.task.vo.ListVO;
import com.task.vo.TaskVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Long save(TaskCO taskCO) {
        Task task = new Task();
        task.setStatus(taskCO.getStatus());
        task.setDate(new Date());
        task = taskRepository.save(task);
        return task.getId();
    }

    @Override
    public Map<Date, AggregateVO> get() {
        Map<Date, AggregateVO> map = new HashMap<>();
        taskRepository.findAll().stream().collect(Collectors.groupingBy(t -> t.getDate(), toList())).entrySet().forEach(
                e -> {
                        map.put(e.getKey(), new AggregateVO(e.getValue()));
                }
        );
        return map;
    }

    @Override
    public ListVO getAll(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<Task> taskPage = taskRepository.findAll(pageable);
        return ListVO.builder().totalPages(taskPage.getTotalPages())
                .pageNo(taskPage.getPageable().getPageNumber())
                .size(taskPage.getPageable().getPageSize())
                .totalElements(taskPage.getTotalElements())
                .data(taskPage.getContent().stream().map(TaskVO::new).collect(toList()))
                .build();
    }

    @Override
    public void delete(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Task not found for the given id"));
        taskRepository.delete(task);
    }

    @Override
    public Long update(Long id,TaskCO taskCO) {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Task not found for the given id"));
        task.setStatus(taskCO.getStatus());
        task.setDate(new Date());
        task = taskRepository.save(task);
        return task.getId();
    }
}