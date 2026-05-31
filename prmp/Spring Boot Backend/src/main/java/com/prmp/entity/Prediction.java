package com.prmp.entity;

import java.time.LocalDateTime;

import com.prmp.enums.RiskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity

public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long predictionId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private Float delayProbability;

    @Enumerated(EnumType.STRING)
    private RiskStatus riskStatus;

    private String recommendation;

    private LocalDateTime generatedAt;
    
    public Prediction() {}

	public Prediction(Long predictionId, Project project, Float delayProbability, RiskStatus riskStatus,
			String recommendation, LocalDateTime generatedAt) {
		super();
		this.predictionId = predictionId;
		this.project = project;
		this.delayProbability = delayProbability;
		this.riskStatus = riskStatus;
		this.recommendation = recommendation;
		this.generatedAt = generatedAt;
	}

	public Long getPredictionId() {
		return predictionId;
	}

	public void setPredictionId(Long predictionId) {
		this.predictionId = predictionId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Float getDelayProbability() {
		return delayProbability;
	}

	public void setDelayProbability(Float delayProbability) {
		this.delayProbability = delayProbability;
	}

	public RiskStatus getRiskStatus() {
		return riskStatus;
	}

	public void setRiskStatus(RiskStatus riskStatus) {
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