package com.prmp.entity;

import java.time.LocalDate;

import com.prmp.enums.*;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "tasks")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    private String title;

    private String description;

    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public Task(Integer taskId, String title, String description, LocalDate dueDate, TaskStatus status,
			TaskPriority priority, Sprint sprint, User assignedUser) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
		this.priority = priority;
		this.sprint = sprint;
		this.assignedUser = assignedUser;
	}

	public Task() {
	}

	
}