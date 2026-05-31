package com.prmp.dto;

import java.time.LocalDate;

import com.prmp.enums.TaskPriority;
import com.prmp.enums.TaskStatus;

public class TaskResponseDTO {

    private Integer taskId;

    private String title;

    private String description;

    private LocalDate dueDate;

    private TaskStatus status;

    private TaskPriority priority;

    private Integer storyPoints;

    private Long sprintId;

    private String sprintName;

    private Long assignedUserId;

    private String assignedUserName;

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

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
    }

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long long1) {
        this.sprintId = long1;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Long long1) {
        this.assignedUserId = long1;
    }

    public String getAssignedUserName() {
        return assignedUserName;
    }

    public void setAssignedUserName(String assignedUserName) {
        this.assignedUserName = assignedUserName;
    }
}