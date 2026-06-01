# NodeJS Notification Service

## Endpoints
POST /notify/taskAssigned → emits to developer room
POST /notify/taskStatusUpdated → emits to developer room
POST /notify/predictionGenerated → emits to developer room
POST /notify/managerFeedbackAdded → emits to manager room
POST /notify/sprintDeadlineAlert → emits to admin room

## Payload Example
{
  "taskId": 123,
  "assignee": "Shreenithi"
}

## Spring Boot Integration
RestTemplate restTemplate = new RestTemplate();
restTemplate.postForObject("http://localhost:4000/notify/taskAssigned", payload, String.class);

## React Integration
const socket = io("http://localhost:4000");
socket.emit("joinRoom", "developer");
socket.on("taskAssigned", (data) => { console.log(data); });
