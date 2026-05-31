package com.prmp.dto;

import java.time.LocalDate;

import com.prmp.enums.SprintStatus;

public class SprintResponseDTO {

    private Long sprintId;

    private Long projectId;

    private String projectName;

    private String sprintName;

    private Integer velocity;

    private LocalDate startDate;

    private LocalDate endDate;

    private SprintStatus status;

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long long1) {
        this.sprintId = long1;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long long1) {
        this.projectId = long1;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public Integer getVelocity() {
        return velocity;
    }

    public void setVelocity(Integer velocity) {
        this.velocity = velocity;
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

    public SprintStatus getStatus() {
        return status;
    }

    public void setStatus(SprintStatus status) {
        this.status = status;
    }
}