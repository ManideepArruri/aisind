package com.prmp.dto;

import com.prmp.enums.AvailabilityStatus;

public class ResourceRequestDTO {

    private Long userId;

    private Long projectId;

    private Float utilizationPct;

    private AvailabilityStatus availability;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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