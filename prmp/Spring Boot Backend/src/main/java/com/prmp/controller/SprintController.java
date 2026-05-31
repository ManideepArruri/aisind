package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.dto.SprintRequestDTO;
import com.prmp.dto.SprintResponseDTO;
import com.prmp.service.SprintService;

@RestController
@RequestMapping("/api/sprints")

public class SprintController {

    @Autowired
    private SprintService sprintService;

    @PostMapping
    public SprintResponseDTO createSprint(@RequestBody SprintRequestDTO requestDTO) {

        return sprintService.createSprint(requestDTO);
    }

    @GetMapping
    public List<SprintResponseDTO> getAllSprints() {

        return sprintService.getAllSprints();
    }

    @GetMapping("/{id}")
    public SprintResponseDTO getSprintById(@PathVariable Long id) {

        return sprintService.getSprintById(id);
    }

    @PutMapping("/{id}")
    public SprintResponseDTO updateSprint(@PathVariable Long id,@RequestBody SprintRequestDTO requestDTO) {

        return sprintService.updateSprint(id,requestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteSprint(@PathVariable Long id) {

        sprintService.deleteSprint(id);

        return "Sprint deleted successfully";
    }
}