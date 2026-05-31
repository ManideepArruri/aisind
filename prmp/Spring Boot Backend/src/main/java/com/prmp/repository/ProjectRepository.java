package com.prmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prmp.entity.Project;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {

}