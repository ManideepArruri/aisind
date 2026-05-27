package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.dto.TaskRequestDTO;
import com.prmp.dto.TaskResponseDTO;
import com.prmp.service.TaskService;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskResponseDTO createTask(
            @RequestBody TaskRequestDTO requestDTO) {

        return taskService.createTask(requestDTO);
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(
            @PathVariable Integer id) {

        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(
            @PathVariable Integer id,
            @RequestBody TaskRequestDTO requestDTO) {

        return taskService.updateTask(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(
            @PathVariable Integer id) {

        taskService.deleteTask(id);

        return "Task deleted successfully";
    }
}