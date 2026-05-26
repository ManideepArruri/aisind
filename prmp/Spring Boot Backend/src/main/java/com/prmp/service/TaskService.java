package com.prmp.service;

import java.util.List;

import com.prmp.entity.Task;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Integer id);

    Task updateTask(Integer id,Task task);

    void deleteTask(Integer id);
}