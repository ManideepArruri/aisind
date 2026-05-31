package com.prmp.dto;

import com.prmp.enums.AvailabilityStatus;

public class ResourceResponseDTO {

    private Long resourceId;

    private Long userId;

    private String userName;

    private Long projectId;

    private String projectName;

    private Float utilizationPct;

    private AvailabilityStatus availability;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Float getUtilizationPct() {
        return utilizationPct;
    }

    public void setUtilizationPct(Float utilizationPct) {
        this.utilizationPct = utilizationPct;
    }

    public AvailabilityStatus getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityStatus availability) {
        this.availability = availability;
    }
}