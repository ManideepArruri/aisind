package com.prmp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.dto.SprintRequestDTO;
import com.prmp.dto.SprintResponseDTO;
import com.prmp.entity.Project;
import com.prmp.entity.Sprint;
import com.prmp.repository.ProjectRepository;
import com.prmp.repository.SprintRepository;
import com.prmp.service.SprintService;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public SprintResponseDTO createSprint(SprintRequestDTO requestDTO) {

        Project project = projectRepository.findById(
                requestDTO.getProjectId())
                .orElseThrow(() ->new RuntimeException("Project not found"));

        Sprint sprint = new Sprint();

        sprint.setProject(project);

        sprint.setSprintName(requestDTO.getSprintName());

        sprint.setVelocity(requestDTO.getVelocity());

        sprint.setStartDate(requestDTO.getStartDate());

        sprint.setEndDate(requestDTO.getEndDate());

        sprint.setStatus(requestDTO.getStatus());

        Sprint savedSprint =sprintRepository.save(sprint);

        return convertToResponseDTO(savedSprint);
    }

    @Override
    public List<SprintResponseDTO> getAllSprints() {

        return sprintRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SprintResponseDTO getSprintById(Long id) {

        Sprint sprint = sprintRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Sprint not found"));

        return convertToResponseDTO(sprint);
    }

    @Override
    public SprintResponseDTO updateSprint(Long id,SprintRequestDTO requestDTO){

        Sprint sprint = sprintRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Sprint not found"));

        Project project = projectRepository.findById(
                requestDTO.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        sprint.setProject(project);

        sprint.setSprintName(requestDTO.getSprintName());

        sprint.setVelocity(requestDTO.getVelocity());

        sprint.setStartDate(requestDTO.getStartDate());

        sprint.setEndDate(requestDTO.getEndDate());

        sprint.setStatus(requestDTO.getStatus());

        Sprint updatedSprint =sprintRepository.save(sprint);

        return convertToResponseDTO(updatedSprint);
    }

    @Override
    public void deleteSprint(Long id) {

        sprintRepository.deleteById(id);
    }

    private SprintResponseDTO convertToResponseDTO(Sprint sprint) {

        SprintResponseDTO responseDTO =new SprintResponseDTO();

        responseDTO.setSprintId(sprint.getSprintId());

        responseDTO.setProjectId(sprint.getProject().getProjectId());

        responseDTO.setProjectName(sprint.getProject().getName());

        responseDTO.setSprintName(sprint.getSprintName());

        responseDTO.setVelocity(sprint.getVelocity());

        responseDTO.setStartDate(sprint.getStartDate());

        responseDTO.setEndDate(sprint.getEndDate());

        responseDTO.setStatus(sprint.getStatus());

        return responseDTO;
    }
}