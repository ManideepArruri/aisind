package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.dto.PredictionResponseDTO;
import com.prmp.entity.Prediction;
import com.prmp.service.PredictionService;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping("/{projectId}")
    public PredictionResponseDTO generatePrediction(@PathVariable Long projectId) {

        return predictionService.generatePrediction(projectId);
    }

    @GetMapping
    public List<PredictionResponseDTO> getAllPredictions() {

        return predictionService.getAllPredictions();
    }

    @GetMapping("/{predictionId}")
    public PredictionResponseDTO getPredictionById(@PathVariable Long predictionId) {

        return predictionService.getPredictionById(predictionId);
    }

    @GetMapping("/project/{projectId}")
    public List<PredictionResponseDTO> getPredictionsByProjectId(
            @PathVariable Long projectId) {

        return predictionService.getPredictionsByProjectId(projectId);
    }
}