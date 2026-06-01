package com.prmp.service;

public interface NotificationService {

    void sendTaskAssignedNotification(String developerName, String taskTitle);

    void sendTaskStatusUpdatedNotification(String taskTitle, String newStatus);

    void sendPredictionGeneratedNotification(String projectName, String riskStatus, Integer probability);

    void sendSprintDeadlineAlert(String sprintName, Integer daysRemaining);

    void sendManagerFeedbackAddedNotification(String developerName, String taskTitle);
}
