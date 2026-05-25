package com.prmp.entity;

import java.time.LocalDate;

import com.prmp.enums.SprintStatus;

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
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sprintId;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	private String sprintName;
	
	private Integer velocity;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	private SprintStatus status;
	
	
}
