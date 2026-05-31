package com.prmp.entity;

import com.prmp.enums.AvailabilityStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resourceId;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private Float utilizationPct;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availability;
    
    public Resource() {}

	public Resource(Long resourceId, User user, Project project, Float utilizationPct,
			AvailabilityStatus availability) {
		super();
		this.resourceId = resourceId;
		this.user = user;
		this.project = project;
		this.utilizationPct = utilizationPct;
		this.availability = availability;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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
