package com.task.controller;

import com.task.co.TaskCO;
import com.task.service.TaskService;
import com.task.vo.AggregateVO;
import com.task.vo.ListVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

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
    public ResponseEntity<ListVO> getAll(@RequestParam int pageNo,
                                         @RequestParam int size) {
        return ResponseEntity.ok(taskService.getAll(pageNo, size));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody TaskCO taskCO) {
        return ResponseEntity.ok(taskService.update(id, taskCO));
    }

    @GetMapping(path = "/matrix")
    public ResponseEntity<Map<Date, AggregateVO>> get() {
        return ResponseEntity.ok(taskService.get());
    }
}