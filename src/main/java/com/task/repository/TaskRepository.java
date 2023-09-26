package com.task.repository;

import com.task.entity.Task;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
