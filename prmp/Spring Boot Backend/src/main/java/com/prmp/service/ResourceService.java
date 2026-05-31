package com.prmp.service;

import java.util.List;

import com.prmp.dto.ResourceRequestDTO;
import com.prmp.dto.ResourceResponseDTO;

public interface ResourceService {

    ResourceResponseDTO createResource(
            ResourceRequestDTO requestDTO);

    List<ResourceResponseDTO> getAllResources();

    ResourceResponseDTO getResourceById(
            Long id);

    ResourceResponseDTO updateResource(
            Long id,
            ResourceRequestDTO requestDTO);

    void deleteResource(Long id);
}