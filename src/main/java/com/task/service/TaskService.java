package com.task.service;

import com.task.co.TaskCO;
import com.task.vo.AggregateVO;
import com.task.vo.ListVO;

import java.util.Date;
import java.util.Map;

public interface TaskService {
    Long save(TaskCO taskCO);

    void delete(Long id);

    Long update(Long id, TaskCO taskCO);

    ListVO getAll(int pageNo, int size);

    Map<Date, AggregateVO> get();
}