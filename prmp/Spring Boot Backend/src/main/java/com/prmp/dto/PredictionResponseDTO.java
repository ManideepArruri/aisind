package com.prmp.dto;

import java.time.LocalDateTime;

public class PredictionResponseDTO {

    private Long predictionId;

    private Long projectId;

    private String projectName;

    private Float delayProbability;

    private String riskStatus;

    private String recommendation;

    private LocalDateTime generatedAt;

	public Long getPredictionId() {
		return predictionId;
	}

	public void setPredictionId(Long predictionId) {
		this.predictionId = predictionId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Float getDelayProbability() {
		return delayProbability;
	}

	public void setDelayProbability(Float delayProbability) {
		this.delayProbability = delayProbability;
	}

	public String getRiskStatus() {
		return riskStatus;
	}

	public void setRiskStatus(String riskStatus) {
		this.riskStatus = riskStatus;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}
    
    
}