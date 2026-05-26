package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.entity.Task;
import com.prmp.service.TaskService;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {

        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id) {

        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Integer id,@RequestBody Task task) {

        return taskService.updateTask(id,task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Integer id) {

        taskService.deleteTask(id);

        return "Task deleted successfully";
    }
}