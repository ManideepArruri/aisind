package com.prmp.dto;

import java.time.LocalDate;

import com.prmp.enums.ProjectStatus;

public class ProjectResponseDTO {

    private Long projectId;

    private String name;

    private Long managerId;

    private String managerName;

    private LocalDate startDate;

    private LocalDate endDate;

    private ProjectStatus status;

    private Float delayRiskScore;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long long1) {
        this.projectId = long1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long long1) {
        this.managerId = long1;
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