package com.prmp.dto;

import java.time.LocalDate;

import com.prmp.enums.ProjectStatus;

public class ProjectResponseDTO {

    private Integer projectId;

    private String name;

    private Integer managerId;

    private String managerName;

    private LocalDate startDate;

    private LocalDate endDate;

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

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
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
}