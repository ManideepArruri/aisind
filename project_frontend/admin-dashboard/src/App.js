import React, { useEffect, useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import LoginPage from "./pages/LoginPage";
import api from "./services/api";
import ProjectsPage from "./pages/ProjectsPage";
import TasksPage from "./pages/TasksPage";
import SprintsPage from "./pages/SprintsPage";
import PredictionsPage from "./pages/PredictionsPage"
import ResourcesPage from "./pages/ResourcesPage";
import AnalyticsPage from "./pages/AnalyticsPage";
import NotificationsPage from "./pages/NotificationsPage";
import SettingsPage from "./pages/SettingsPage";

import "react-toastify/dist/ReactToastify.css";

import socket from "./services/socket";
import AdminDashboard from "./pages/AdminDashboard";
import UserDashboard from "./pages/UserDashboard";
import ManagerDashboard from "./pages/ManagerDashboard";


function App() {
  useEffect(() => {
    // fake role for now
    const userRole = "admin";
    api.get("/projects")
  .then((response) => {
    console.log("PROJECTS:", response.data);
  })
  .catch((error) => {
    console.log("ERROR:", error.response);
  });

    socket.connect();

    socket.emit("joinRoom", userRole);

    socket.on("connect", () => {
      console.log("Connected:", socket.id);
    });

    socket.on("taskAssigned", (data) => {
      toast.info(`Task Assigned: ${data.message}`);
    });

    socket.on("taskStatusUpdated", (data) => {
      toast.success(`Task Updated: ${data.message}`);
    });

    socket.on("predictionGenerated", (data) => {
      toast.warning(`Prediction: ${data.message}`);
    });

    socket.on("sprintDeadlineAlert", (data) => {
      toast.error(`Deadline Alert: ${data.message}`);
    });

    socket.on("managerFeedbackAdded", (data) => {
      toast.info(`Feedback: ${data.message}`);
    });

    return () => {
      socket.off("taskAssigned");
      socket.off("taskStatusUpdated");
      socket.off("predictionGenerated");
      socket.off("sprintDeadlineAlert");
      socket.off("managerFeedbackAdded");
    };
  }, []);

  return (
    <>
      <Routes>
        <Route path="/" element={<LoginPage />} />

        <Route path="/dashboard" element={<AdminDashboard />} />
        <Route
            path="/projects"
            element={<ProjectsPage />}
        />
        <Route path="/sprints" element={<SprintsPage />} />
        <Route path="/tasks" element={<TasksPage />} />
        <Route path="/resources" element={<ResourcesPage />} />
        <Route path="/analytics" element={<AnalyticsPage />} />
        <Route path="/delay-risk" element={<PredictionsPage />} />
        <Route
          path="/notifications"
          element={<NotificationsPage />}
        />
        <Route
  path="/dashboard/user"
  element={<UserDashboard />}
/>
<Route
  path="/dashboard/manager"
  element={<ManagerDashboard />}
/>
        <Route path="/settings" element={<SettingsPage />} />
      </Routes>

      <ToastContainer position="top-right" autoClose={3000} />
    </>
  );
}

export default App;