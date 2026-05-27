import React from "react";
import "./ManagerDashboard.css";

import Navbar from "../components/Navbar";
import ManagerSidebar from "../components/ManagerSidebar";
import ManagerStatCard from "../components/ManagerStatCard";
import TeamTaskTable from "../components/TeamTaskTable";
import Notifications from "../components/Notifications";

function ManagerDashboard() {
  return (
    <div className="manager-dashboard-container">
      <ManagerSidebar />

      <div className="manager-main-content">
        <Navbar role="Manager" />

        <div className="manager-dashboard-body">
          <h1>Manager Dashboard</h1>
          <p>
            Track sprint performance and
            manage team workload
          </p>

          <div className="manager-stats-section">
            <ManagerStatCard
              title="Team Tasks"
              value="32"
            />

            <ManagerStatCard
              title="Active Sprint"
              value="Sprint 12"
            />

            <ManagerStatCard
              title="Delay Risk"
              value="Moderate"
            />

            <ManagerStatCard
              title="Team Utilization"
              value="81%"
            />
          </div>

          <div className="manager-chart-section">
            <div className="manager-card">
              <h2>Sprint Progress</h2>
              <div className="manager-progress-bar">
                <div className="manager-progress-fill"></div>
              </div>

              <p>75% completed</p>
            </div>

            <div className="manager-card">
              <h2>Team Performance</h2>
              <h1>89%</h1>
              <p>
                Team delivery performance
              </p>
            </div>
          </div>

          <TeamTaskTable />

          <Notifications />
        </div>
      </div>
    </div>
  );
}

export default ManagerDashboard;