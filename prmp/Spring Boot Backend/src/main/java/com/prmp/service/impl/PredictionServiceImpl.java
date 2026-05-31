package com.prmp.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prmp.dto.FastApiPredictionResponse;
import com.prmp.dto.PredictionResponseDTO;
import com.prmp.entity.Prediction;
import com.prmp.entity.Project;
import com.prmp.enums.RiskStatus;
import com.prmp.repository.PredictionRepository;
import com.prmp.repository.ProjectRepository;
import com.prmp.service.PredictionService;

@Service
public class PredictionServiceImpl implements PredictionService {

    @Autowired
    private PredictionRepository predictionRepository;

    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PredictionResponseDTO generatePrediction(
            Long projectId) {

        Project project = projectRepository
                .findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        Prediction prediction = new Prediction();

        prediction.setProject(project);

        FastApiPredictionResponse response =
                restTemplate.getForObject(
                        "http://localhost:8000/predict/" + projectId,
                        FastApiPredictionResponse.class);
        
        prediction.setDelayProbability(
                response.getDelay_probability() / 100.0f);

        prediction.setRiskStatus(
                RiskStatus.valueOf(
                        response.getRisk_status()));

        prediction.setRecommendation(
                response.getRecommendation());

        prediction.setGeneratedAt(
                LocalDateTime.now());

        Prediction savedPrediction =
                predictionRepository.save(prediction);

        return convertToResponseDTO(
                savedPrediction);
    }

    @Override
    public List<PredictionResponseDTO> getAllPredictions() {

        return predictionRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PredictionResponseDTO getPredictionById(
            Long predictionId) {

        Prediction prediction =
                predictionRepository.findById(
                        predictionId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Prediction not found"));

        return convertToResponseDTO(
                prediction);
    }

    @Override
    public List<PredictionResponseDTO>
            getPredictionsByProjectId(
                    Long projectId) {

        return predictionRepository
                .findByProject_ProjectId(projectId)
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private PredictionResponseDTO
            convertToResponseDTO(
                    Prediction prediction) {

        PredictionResponseDTO dto =
                new PredictionResponseDTO();

        dto.setPredictionId(
                prediction.getPredictionId());

        dto.setProjectId(
                prediction.getProject()
                        .getProjectId());

        dto.setProjectName(
                prediction.getProject()
                        .getName());

        dto.setDelayProbability(
                prediction.getDelayProbability());

        dto.setRiskStatus(
                prediction.getRiskStatus()
                        .name());

        dto.setRecommendation(
                prediction.getRecommendation());

        dto.setGeneratedAt(
                prediction.getGeneratedAt());

        return dto;
    }
}