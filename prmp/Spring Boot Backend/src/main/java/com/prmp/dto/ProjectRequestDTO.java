package com.prmp.dto;

import java.time.LocalDate;

import com.prmp.enums.ProjectStatus;

public class ProjectRequestDTO {

    private String name;

    private Long managerId;

    private LocalDate startDate;

    private LocalDate endDate;

    private ProjectStatus status;

    private Float delayRiskScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
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