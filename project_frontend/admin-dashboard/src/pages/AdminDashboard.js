import React from "react";
import "./AdminDashboard.css";

import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";
import StatCard from "../components/StatCard";
import RecentProjects from "../components/RecentProjects";
import Notifications from "../components/Notifications";

function AdminDashboard() {
  return (
    <div className="dashboard-container">
      <Sidebar />

      <div className="main-content">
        <Navbar role="Admin" />

        <div className="dashboard-body">
          <h1>Admin Dashboard</h1>

          <div className="stats-section">
            <StatCard title="Active Projects" value="12" />
            <StatCard title="Delayed Projects" value="3" />
            <StatCard title="Team Members" value="48" />
            <StatCard title="Sprint Velocity" value="74%" />
          </div>

          <div className="charts-section">
            <div className="chart-card">
              <h3>Sprint Velocity Trend</h3>
              <div className="fake-chart">Chart Placeholder</div>
            </div>

            <div className="chart-card">
              <h3>Project Status</h3>
              <div className="fake-chart">Chart Placeholder</div>
            </div>
          </div>

          <div className="bottom-section">
            <div className="projects">
              <RecentProjects />
            </div>

            <div className="notifications">
              <Notifications />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AdminDashboard;