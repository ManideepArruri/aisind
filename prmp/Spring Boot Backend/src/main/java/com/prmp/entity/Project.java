package com.prmp.entity;

import java.time.LocalDate;


import com.prmp.enums.ProjectStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	
	private String name;
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private User manager;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	private ProjectStatus status;
	
	private Float delayRiskScore;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public Float getDelayRiskScore() {
		return delayRiskScore;
	}

	public void setDelayRiskScore(Float delayRiskScore) {
		this.delayRiskScore = delayRiskScore;
	}

	public Project(Integer projectId, String name, User manager, LocalDate startDate, LocalDate endDate,
			ProjectStatus status, Float delayRiskScore) {
	
		this.projectId = projectId;
		this.name = name;
		this.manager = manager;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.delayRiskScore = delayRiskScore;
	}

	public Project() {
		
	}


}
