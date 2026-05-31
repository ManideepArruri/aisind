package com.prmp.service;

import java.util.List;

import com.prmp.dto.ProjectRequestDTO;
import com.prmp.dto.ProjectResponseDTO;

public interface ProjectService {

    ProjectResponseDTO createProject(ProjectRequestDTO requestDTO);

    List<ProjectResponseDTO> getAllProjects();

    ProjectResponseDTO getProjectById(Long id);

    ProjectResponseDTO updateProject(Long id,ProjectRequestDTO requestDTO);

    void deleteProject(Long id);
}