package com.prmp.service;

import java.util.List;

import com.prmp.dto.TaskRequestDTO;
import com.prmp.dto.TaskResponseDTO;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO requestDTO);

    List<TaskResponseDTO> getAllTasks();

    TaskResponseDTO getTaskById(Integer id);

    TaskResponseDTO updateTask(
            Integer id,
            TaskRequestDTO requestDTO);

    void deleteTask(Integer id);
}