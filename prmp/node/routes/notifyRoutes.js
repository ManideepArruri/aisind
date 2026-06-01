const express = require("express");
const router = express.Router();

module.exports = (io) => {
  // Task Assigned
  router.post("/taskAssigned", (req, res) => {
    const data = req.body;
    io.to("developer").emit("taskAssigned", data);
    res.json({ message: "Task Assigned notification sent", data });
  });

  // Task Status Updated
  router.post("/taskStatusUpdated", (req, res) => {
    const data = req.body;
    io.emit("taskStatusUpdated", data);
    res.json({ message: "Task Status Updated notification sent", data });
  });

  // Prediction Generated
  router.post("/predictionGenerated", (req, res) => {
    const data = req.body;
    io.emit("predictionGenerated", data);
    res.json({ message: "Prediction notification sent", data });
  });

  // Sprint Deadline Alert
  router.post("/sprintDeadlineAlert", (req, res) => {
    const data = req.body;
    io.to("admin").emit("sprintDeadlineAlert", data);
    res.json({ message: "Sprint Deadline Alert sent", data });
  });

  // Manager Feedback Added
  router.post("/managerFeedbackAdded", (req, res) => {
    const data = req.body;
    io.to("manager").emit("managerFeedbackAdded", data);
    res.json({ message: "Manager Feedback notification sent", data });
  });

  return router;
};
