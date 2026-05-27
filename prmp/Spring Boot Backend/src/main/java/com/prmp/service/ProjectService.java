package com.prmp.service;

import java.util.List;

import com.prmp.dto.ProjectRequestDTO;
import com.prmp.dto.ProjectResponseDTO;

public interface ProjectService {

    ProjectResponseDTO createProject(ProjectRequestDTO requestDTO);

    List<ProjectResponseDTO> getAllProjects();

    ProjectResponseDTO getProjectById(Integer id);

    ProjectResponseDTO updateProject(Integer id,ProjectRequestDTO requestDTO);

    void deleteProject(Integer id);
}