import React from "react";
import "./UserDashboard.css";

import Navbar from "../components/Navbar";
import UserSidebar from "../components/UserSidebar";
import PerformanceCard from "../components/PerformanceCard";
import TaskTable from "../components/TaskTable";
import Notifications from "../components/Notifications";

function UserDashboard() {
  return (
    <div className="user-dashboard-container">
      <UserSidebar />

      <div className="user-main-content">
        <Navbar role="Developer" />

        <div className="user-dashboard-body">
          <h1>Hello Rahul 👋</h1>
          <p>Welcome back to your workspace</p>

          <div className="performance-section">
            <PerformanceCard
              title="Assigned Tasks"
              value="12"
            />

            <PerformanceCard
              title="Completed"
              value="8"
            />

            <PerformanceCard
              title="Pending"
              value="4"
            />

            <PerformanceCard
              title="Performance"
              value="89%"
            />
          </div>

          <div className="risk-section">
            <div className="risk-card">
              <h2>Delay Risk</h2>
              <h1>Moderate Risk</h1>
              <p>
                Project risk prediction generated
              </p>
            </div>

            <div className="sprint-card">
              <h2>Sprint Progress</h2>
              <div className="progress-bar">
                <div className="progress-fill"></div>
              </div>
              <p>70% completed</p>
            </div>
          </div>

          <TaskTable />

          <Notifications />
        </div>
      </div>
    </div>
  );
}

export default UserDashboard;