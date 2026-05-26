package com.prmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.entity.Project;
import com.prmp.repository.ProjectRepository;
import com.prmp.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {

        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Integer id) {

        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Project not found"));
    }

    @Override
    public Project updateProject(Integer id,Project updatedProject) {

        Project project = getProjectById(id);

        project.setName(updatedProject.getName());

        project.setManager(updatedProject.getManager());

        project.setStartDate(updatedProject.getStartDate());

        project.setEndDate(updatedProject.getEndDate());

        project.setStatus(updatedProject.getStatus());

        project.setDelayRiskScore(updatedProject.getDelayRiskScore());

        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Integer id) {

        projectRepository.deleteById(id);
    }
}