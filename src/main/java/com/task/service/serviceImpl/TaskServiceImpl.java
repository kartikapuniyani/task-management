package com.task.service.serviceImpl;

import com.task.co.TaskCO;
import com.task.entity.Task;
import com.task.repository.TaskRepository;
import com.task.service.TaskService;
import com.task.vo.TaskVO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<TaskVO> getAll() {
        return taskRepository.findAll().stream().map(TaskVO::new).collect(Collectors.toList());
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

//    public <T> ListResponseVO<T> getListResponseVO(Boolean isPageable, Integer page, Integer size, List<T> responseList) {
//        long totalElements = responseList.size();
//        long totalPages = 0;
//        if (null != isPageable && isPageable) {
//            validatePageMetaData(page);
//            if (null == size || size == 0) {
//                size = DEFAULT_PAGE_SIZE;
//            }
//            int skipCount = (page - 1) * size;
//            responseList = responseList.stream().skip(skipCount).limit(size).collect(Collectors.toList());
//            totalPages = totalElements / size;
//            if (totalElements % size != 0) {
//                totalPages = totalPages + 1;
//            }
//        }
//        return new ListResponseVO<T>(responseList, totalElements, totalPages, page, size);
//    }
}