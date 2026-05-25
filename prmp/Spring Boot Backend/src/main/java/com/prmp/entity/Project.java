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
	
}
