package com.prmp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.dto.ResourceRequestDTO;
import com.prmp.dto.ResourceResponseDTO;
import com.prmp.entity.Project;
import com.prmp.entity.Resource;
import com.prmp.entity.User;
import com.prmp.repository.ProjectRepository;
import com.prmp.repository.ResourceRepository;
import com.prmp.repository.UserRepository;
import com.prmp.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ResourceResponseDTO createResource(
            ResourceRequestDTO requestDTO) {

        User user = userRepository.findById(
                requestDTO.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Project project = projectRepository.findById(
                requestDTO.getProjectId())
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        Resource resource = new Resource();

        resource.setUser(user);

        resource.setProject(project);

        resource.setUtilizationPct(
                requestDTO.getUtilizationPct());

        resource.setAvailability(
                requestDTO.getAvailability());

        Resource savedResource =
                resourceRepository.save(resource);

        return convertToResponseDTO(
                savedResource);
    }

    @Override
    public List<ResourceResponseDTO> getAllResources() {

        return resourceRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResourceResponseDTO getResourceById(
            Long id) {

        Resource resource =
                resourceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Resource not found"));

        return convertToResponseDTO(resource);
    }

    @Override
    public ResourceResponseDTO updateResource(
            Long id,
            ResourceRequestDTO requestDTO) {

        Resource resource =
                resourceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Resource not found"));

        User user = userRepository.findById(
                requestDTO.getUserId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"));

        Project project =
                projectRepository.findById(
                        requestDTO.getProjectId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Project not found"));

        resource.setUser(user);

        resource.setProject(project);

        resource.setUtilizationPct(
                requestDTO.getUtilizationPct());

        resource.setAvailability(
                requestDTO.getAvailability());

        Resource updatedResource =
                resourceRepository.save(resource);

        return convertToResponseDTO(
                updatedResource);
    }

    @Override
    public void deleteResource(Long id) {

        resourceRepository.deleteById(id);
    }

    private ResourceResponseDTO convertToResponseDTO(
            Resource resource) {

        ResourceResponseDTO dto =
                new ResourceResponseDTO();

        dto.setResourceId(
                resource.getResourceId());

        dto.setUserId(
                resource.getUser().getId());

        dto.setUserName(
                resource.getUser().getName());

        dto.setProjectId(
                resource.getProject().getProjectId());

        dto.setProjectName(
                resource.getProject().getName());

        dto.setUtilizationPct(
                resource.getUtilizationPct());

        dto.setAvailability(
                resource.getAvailability());

        return dto;
    }
}