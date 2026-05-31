package com.prmp.service;

import java.util.List;

import com.prmp.dto.SprintRequestDTO;
import com.prmp.dto.SprintResponseDTO;

public interface SprintService {

    SprintResponseDTO createSprint(SprintRequestDTO requestDTO);

    List<SprintResponseDTO> getAllSprints();

    SprintResponseDTO getSprintById(Long id);

    SprintResponseDTO updateSprint(Long id,SprintRequestDTO requestDTO);

    void deleteSprint(Long id);
}