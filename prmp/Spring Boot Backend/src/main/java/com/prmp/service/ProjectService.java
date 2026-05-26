package com.prmp.service;

import java.util.List;

import com.prmp.entity.Project;

public interface ProjectService {

    Project createProject(Project project);

    List<Project> getAllProjects();

    Project getProjectById(Integer id);

    Project updateProject(Integer id,Project project);

    void deleteProject(Integer id);
}