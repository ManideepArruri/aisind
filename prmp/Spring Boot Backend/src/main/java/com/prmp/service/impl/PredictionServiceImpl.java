package com.prmp.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.prmp.entity.Prediction;
import com.prmp.entity.Project;
import com.prmp.enums.RiskStatus;
import com.prmp.repository.PredictionRepository;
import com.prmp.repository.ProjectRepository;
import com.prmp.service.PredictionService;

public class PredictionServiceImpl implements PredictionService{
	
@Autowired
private PredictionRepository predictionRepository;

@Autowired
private ProjectRepository projectRepository;

@Override
public Prediction generatePrediction(Integer projectId){
	Project project = projectRepository.findById(projectId)
            .orElseThrow(() ->new RuntimeException("Project not found"));

    Prediction prediction =new Prediction();

    prediction.setProject(project);

    prediction.setDelayProbability(0.72f);

    prediction.setRiskStatus(RiskStatus.HIGH_RISK);

    prediction.setRecommendation("Increase developer allocation");

    prediction.setGeneratedAt(LocalDateTime.now());

    return predictionRepository.save(prediction);
}
}
