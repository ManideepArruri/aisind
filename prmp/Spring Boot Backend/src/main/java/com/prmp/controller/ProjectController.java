package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.entity.Project;
import com.prmp.service.ProjectService;

@RestController
@RequestMapping("/api/projects")

public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project createProject(@RequestBody Project project) {

        return projectService.createProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {

        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Integer id) {

        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Integer id,@RequestBody Project project) {

        return projectService.updateProject(id,project);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Integer id) {

        projectService.deleteProject(id);

        return "Project deleted successfully";
    }
}