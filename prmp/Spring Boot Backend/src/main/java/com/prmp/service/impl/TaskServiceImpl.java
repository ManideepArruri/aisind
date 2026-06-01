package com.prmp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.dto.TaskRequestDTO;
import com.prmp.dto.TaskResponseDTO;
import com.prmp.entity.Sprint;
import com.prmp.entity.Task;
import com.prmp.entity.User;
import com.prmp.repository.SprintRepository;
import com.prmp.repository.TaskRepository;
import com.prmp.repository.UserRepository;
import com.prmp.service.TaskService;
import com.prmp.service.NotificationService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    @Override
    public TaskResponseDTO createTask(
            TaskRequestDTO requestDTO) {

        Sprint sprint = sprintRepository.findById(
                requestDTO.getSprintId())
                .orElseThrow(() ->
                        new RuntimeException("Sprint not found"));

        User assignedUser = userRepository.findById(
                requestDTO.getAssignedUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Task task = new Task();

        task.setTitle(requestDTO.getTitle());

        task.setDescription(requestDTO.getDescription());

        task.setDueDate(requestDTO.getDueDate());

        task.setStatus(requestDTO.getStatus());

        task.setPriority(requestDTO.getPriority());

        task.setStoryPoints(requestDTO.getStoryPoints());

        task.setSprint(sprint);

        task.setAssignedUser(assignedUser);

        Task savedTask = taskRepository.save(task);

        TaskResponseDTO responseDTO = convertToResponseDTO(savedTask);
        notificationService.sendTaskAssignedNotification(responseDTO.getAssignedUserName(), responseDTO.getTitle());
        return responseDTO;
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {

        return taskRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDTO getTaskById(Integer id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        return convertToResponseDTO(task);
    }

    @Override
    public TaskResponseDTO updateTask(
            Integer id,
            TaskRequestDTO requestDTO) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        Sprint sprint = sprintRepository.findById(
                requestDTO.getSprintId())
                .orElseThrow(() ->
                        new RuntimeException("Sprint not found"));

        User assignedUser = userRepository.findById(
                requestDTO.getAssignedUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        task.setTitle(requestDTO.getTitle());

        task.setDescription(requestDTO.getDescription());

        task.setDueDate(requestDTO.getDueDate());

        task.setStatus(requestDTO.getStatus());

        task.setPriority(requestDTO.getPriority());

        task.setStoryPoints(requestDTO.getStoryPoints());

        task.setSprint(sprint);

        task.setAssignedUser(assignedUser);

        Task updatedTask = taskRepository.save(task);

        TaskResponseDTO responseDTO = convertToResponseDTO(updatedTask);
        notificationService.sendTaskStatusUpdatedNotification(responseDTO.getTitle(), responseDTO.getStatus().name());
        return responseDTO;
    }

    @Override
    public void deleteTask(Integer id) {

        taskRepository.deleteById(id);
    }

    private TaskResponseDTO convertToResponseDTO(
            Task task) {

        TaskResponseDTO responseDTO =
                new TaskResponseDTO();

        responseDTO.setTaskId(task.getTaskId());

        responseDTO.setTitle(task.getTitle());

        responseDTO.setDescription(task.getDescription());

        responseDTO.setDueDate(task.getDueDate());

        responseDTO.setStatus(task.getStatus());

        responseDTO.setPriority(task.getPriority());

        responseDTO.setStoryPoints(task.getStoryPoints());

        responseDTO.setSprintId(
                task.getSprint().getSprintId());

        responseDTO.setSprintName(
                task.getSprint().getSprintName());

        responseDTO.setAssignedUserId(
                task.getAssignedUser().getId());

        responseDTO.setAssignedUserName(
                task.getAssignedUser().getName());

        return responseDTO;
    }
}