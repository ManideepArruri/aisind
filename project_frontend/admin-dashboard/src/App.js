import React, { useEffect } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";

import "react-toastify/dist/ReactToastify.css";

import socket from "./services/socket";
import AdminDashboard from "./pages/AdminDashboard";
import UserDashboard from "./pages/UserDashboard";
import ManagerDashboard from "./pages/ManagerDashboard";
function Projects() {
  return <h1 style={{ padding: "30px" }}>Projects Page</h1>;
}

function Sprints() {
  return <h1 style={{ padding: "30px" }}>Sprints Page</h1>;
}

function Tasks() {
  return <h1 style={{ padding: "30px" }}>Tasks Page</h1>;
}

function Resources() {
  return <h1 style={{ padding: "30px" }}>Resources Page</h1>;
}

function Analytics() {
  return <h1 style={{ padding: "30px" }}>Analytics Page</h1>;
}

function DelayRisk() {
  return <h1 style={{ padding: "30px" }}>Delay Risk Page</h1>;
}

function NotificationsPage() {
  return <h1 style={{ padding: "30px" }}>Notifications Page</h1>;
}

function Settings() {
  return <h1 style={{ padding: "30px" }}>Settings Page</h1>;
}

function App() {
  useEffect(() => {
    // fake role for now
    const userRole = "admin";

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
        <Route path="/" element={<Navigate to="/dashboard" />} />

        <Route path="/dashboard" element={<AdminDashboard />} />
        <Route path="/projects" element={<Projects />} />
        <Route path="/sprints" element={<Sprints />} />
        <Route path="/tasks" element={<Tasks />} />
        <Route path="/resources" element={<Resources />} />
        <Route path="/analytics" element={<Analytics />} />
        <Route path="/delay-risk" element={<DelayRisk />} />
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
        <Route path="/settings" element={<Settings />} />
      </Routes>

      <ToastContainer position="top-right" autoClose={3000} />
    </>
  );
}

export default App;