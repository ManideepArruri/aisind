package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.dto.ProjectRequestDTO;
import com.prmp.dto.ProjectResponseDTO;
import com.prmp.service.ProjectService;

@RestController
@RequestMapping("/api/projects")

public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ProjectResponseDTO createProject( @RequestBody ProjectRequestDTO requestDTO){

        return projectService.createProject(requestDTO);
    }

    @GetMapping
    public List<ProjectResponseDTO> getAllProjects() {

        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponseDTO getProjectById(@PathVariable Long id) {

        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public ProjectResponseDTO updateProject( @PathVariable Long id,@RequestBody ProjectRequestDTO requestDTO) {

        return projectService.updateProject(id,requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {

        projectService.deleteProject(id);

        return "Project deleted successfully";
    }
}