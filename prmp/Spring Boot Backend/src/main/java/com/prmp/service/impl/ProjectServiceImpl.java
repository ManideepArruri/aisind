package com.prmp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.dto.ProjectRequestDTO;
import com.prmp.dto.ProjectResponseDTO;
import com.prmp.entity.Project;
import com.prmp.entity.User;
import com.prmp.repository.ProjectRepository;
import com.prmp.repository.UserRepository;
import com.prmp.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProjectResponseDTO createProject(
            ProjectRequestDTO requestDTO) {

        User manager = userRepository.findById(
                requestDTO.getManagerId())
                .orElseThrow(() ->new RuntimeException("Manager not found"));

        Project project = new Project();

        project.setName(requestDTO.getName());

        project.setManager(manager);

        project.setStartDate(requestDTO.getStartDate());

        project.setEndDate(requestDTO.getEndDate());

        project.setStatus(requestDTO.getStatus());

        project.setDelayRiskScore(requestDTO.getDelayRiskScore());

        Project savedProject =projectRepository.save(project);

        return convertToResponseDTO(savedProject);
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponseDTO getProjectById(Long id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Project not found"));

        return convertToResponseDTO(project);
    }

    @Override
    public ProjectResponseDTO updateProject(
            Long id,
            ProjectRequestDTO requestDTO) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Project not found"));

        User manager = userRepository.findById(
                requestDTO.getManagerId())
                .orElseThrow(() ->new RuntimeException("Manager not found"));

        project.setName(requestDTO.getName());

        project.setManager(manager);

        project.setStartDate(requestDTO.getStartDate());

        project.setEndDate(requestDTO.getEndDate());

        project.setStatus(requestDTO.getStatus());

        project.setDelayRiskScore(requestDTO.getDelayRiskScore());

        Project updatedProject =projectRepository.save(project);

        return convertToResponseDTO(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {

        projectRepository.deleteById(id);
    }

    private ProjectResponseDTO convertToResponseDTO(
            Project project) {

        ProjectResponseDTO responseDTO =new ProjectResponseDTO();

        responseDTO.setProjectId(project.getProjectId());

        responseDTO.setName(project.getName());

        responseDTO.setManagerId(project.getManager().getId());

        responseDTO.setManagerName(project.getManager().getName());

        responseDTO.setStartDate(project.getStartDate());

        responseDTO.setEndDate(project.getEndDate());

        responseDTO.setStatus(project.getStatus());

        responseDTO.setDelayRiskScore(project.getDelayRiskScore());

        return responseDTO;
    }
}