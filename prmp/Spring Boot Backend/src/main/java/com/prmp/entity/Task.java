package com.prmp.entity;

import jakarta.persistence.Entity;
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
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private Sprint sprint;
	
	@ManyToOne
	@JoinColumn(name = "assignee_id")
	private User assignee;
	
	private String title;
	
	
	
}
