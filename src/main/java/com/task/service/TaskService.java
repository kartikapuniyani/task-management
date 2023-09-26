package com.task.service;

import com.task.co.TaskCO;
import com.task.vo.TaskVO;

import java.util.List;

public interface TaskService {
    Long save(TaskCO taskCO);

    List<TaskVO> getAll();

    void delete(Long id);

    Long update(Long id, TaskCO taskCO);
}