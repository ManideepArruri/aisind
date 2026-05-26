package com.prmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.entity.Task;
import com.prmp.repository.TaskRepository;
import com.prmp.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Integer id) {

        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public Task updateTask(Integer id,Task updatedTask) {

        Task task = getTaskById(id);

        task.setTitle(updatedTask.getTitle());

        task.setDescription(updatedTask.getDescription());

        task.setDueDate(updatedTask.getDueDate());

        task.setStatus(updatedTask.getStatus());

        task.setPriority(updatedTask.getPriority());

        task.setSprint(updatedTask.getSprint());

        task.setAssignedUser(updatedTask.getAssignedUser());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {

        taskRepository.deleteById(id);
    }
}