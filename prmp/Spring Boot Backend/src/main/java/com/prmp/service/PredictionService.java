package com.prmp.service;

import com.prmp.dto.PredictionResponseDTO;
import com.prmp.entity.Prediction;

import java.util.List;

public interface PredictionService {

    PredictionResponseDTO generatePrediction(Long projectId);

    List<PredictionResponseDTO> getAllPredictions();

    PredictionResponseDTO getPredictionById(Long predictionId);

    List<PredictionResponseDTO> getPredictionsByProjectId(Long projectId);
}