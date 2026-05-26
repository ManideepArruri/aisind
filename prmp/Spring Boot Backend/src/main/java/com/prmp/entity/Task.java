package com.prmp.entity;

import com.prmp.enums.TaskPriority;
import com.prmp.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
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
	
	@Enumerated(EnumType.STRING)
	private TaskPriority priority;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	private Integer storyPoints;
	
	

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Task() {}

	public Task(Integer taskId, Sprint sprint, User assignee, String title) {
		
		this.taskId = taskId;
		this.sprint = sprint;
		this.assignee = assignee;
		this.title = title;
	}
	
	public TaskPriority getTaskPriority() {
		return this.priority;
	}
	
	public TaskStatus getTaskStatus() {
		return this.status;
	}
	
	public Integer getStoryPoints() {
		return this.storyPoints;
	}
	
	
	
}
