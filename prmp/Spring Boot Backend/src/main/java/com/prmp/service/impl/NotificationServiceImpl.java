package com.prmp.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.prmp.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String NODE_NOTIFY_URL = "http://localhost:4000/notify";

    @Override
    public void sendTaskAssignedNotification(String developerName, String taskTitle) {
        String msg = String.format("Task '%s' has been assigned to %s", taskTitle, developerName);
        sendPost(NODE_NOTIFY_URL + "/taskAssigned", msg);
    }

    @Override
    public void sendTaskStatusUpdatedNotification(String taskTitle, String newStatus) {
        String msg = String.format("Task '%s' status updated to %s", taskTitle, newStatus);
        sendPost(NODE_NOTIFY_URL + "/taskStatusUpdated", msg);
    }

    @Override
    public void sendPredictionGeneratedNotification(String projectName, String riskStatus, Integer probability) {
        String msg = String.format("Prediction for project '%s': %s (Probability: %d%%)", projectName, riskStatus, probability);
        sendPost(NODE_NOTIFY_URL + "/predictionGenerated", msg);
    }

    @Override
    public void sendSprintDeadlineAlert(String sprintName, Integer daysRemaining) {
        String msg = String.format("Sprint '%s' is approaching its deadline. %d days remaining!", sprintName, daysRemaining);
        sendPost(NODE_NOTIFY_URL + "/sprintDeadlineAlert", msg);
    }

    @Override
    public void sendManagerFeedbackAddedNotification(String developerName, String taskTitle) {
        String msg = String.format("New manager feedback added for task '%s'", taskTitle);
        sendPost(NODE_NOTIFY_URL + "/managerFeedbackAdded", msg);
    }

    private void sendPost(String url, String message) {
        try {
            Map<String, String> body = new HashMap<>();
            body.put("message", message);
            restTemplate.postForObject(url, body, String.class);
        } catch (Exception e) {
            System.err.println("Failed to send real-time notification to " + url + ": " + e.getMessage());
        }
    }
}
