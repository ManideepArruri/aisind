package com.prmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prmp.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
