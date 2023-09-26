package com.task.controller;

import com.task.co.TaskCO;
import com.task.service.TaskService;
import com.task.vo.TaskVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Long> save(@RequestBody TaskCO taskCO) {
        return ResponseEntity.ok(taskService.save(taskCO));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<TaskVO>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/update/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody TaskCO taskCO) {
        return ResponseEntity.ok(taskService.update(id, taskCO));
    }
}