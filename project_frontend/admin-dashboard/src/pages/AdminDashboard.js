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
              <div className="chart-container">
                <svg viewBox="0 0 500 220" width="100%" height="100%">
                  <defs>
                    <linearGradient id="velocityGrad" x1="0" y1="0" x2="0" y2="1">
                      <stop offset="0%" stopColor="var(--accent-purple)" stopOpacity="0.4" />
                      <stop offset="100%" stopColor="var(--accent-purple)" stopOpacity="0.0" />
                    </linearGradient>
                  </defs>
                  
                  {/* Grid Lines */}
                  <line x1="40" y1="20" x2="480" y2="20" stroke="var(--border-color)" strokeWidth="1" strokeDasharray="4 4" />
                  <line x1="40" y1="65" x2="480" y2="65" stroke="var(--border-color)" strokeWidth="1" strokeDasharray="4 4" />
                  <line x1="40" y1="110" x2="480" y2="110" stroke="var(--border-color)" strokeWidth="1" strokeDasharray="4 4" />
                  <line x1="40" y1="155" x2="480" y2="155" stroke="var(--border-color)" strokeWidth="1" strokeDasharray="4 4" />
                  <line x1="40" y1="200" x2="480" y2="200" stroke="var(--border-color)" strokeWidth="1" />

                  {/* Y Axis Labels */}
                  <text x="15" y="24" fill="var(--text-muted)" fontSize="10" textAnchor="middle">100%</text>
                  <text x="15" y="69" fill="var(--text-muted)" fontSize="10" textAnchor="middle">75%</text>
                  <text x="15" y="114" fill="var(--text-muted)" fontSize="10" textAnchor="middle">50%</text>
                  <text x="15" y="159" fill="var(--text-muted)" fontSize="10" textAnchor="middle">25%</text>
                  <text x="15" y="204" fill="var(--text-muted)" fontSize="10" textAnchor="middle">0%</text>

                  {/* Gradient Area under Curve */}
                  <path d="M 60,200 L 60,130 C 100,120 140,150 180,100 C 220,50 260,80 300,70 C 340,60 380,110 420,60 L 460,50 L 460,200 Z" fill="url(#velocityGrad)" />

                  {/* Line Chart Path */}
                  <path d="M 60,130 C 100,120 140,150 180,100 C 220,50 260,80 300,70 C 340,60 380,110 420,60 L 460,50" fill="none" stroke="var(--accent-purple)" strokeWidth="3" />

                  {/* Data Points */}
                  <circle cx="60" cy="130" r="4" fill="var(--accent-purple)" stroke="var(--bg-secondary)" strokeWidth="2" />
                  <circle cx="180" cy="100" r="4" fill="var(--accent-purple)" stroke="var(--bg-secondary)" strokeWidth="2" />
                  <circle cx="300" cy="70" r="4" fill="var(--accent-purple)" stroke="var(--bg-secondary)" strokeWidth="2" />
                  <circle cx="420" cy="60" r="4" fill="var(--accent-purple)" stroke="var(--bg-secondary)" strokeWidth="2" />
                  <circle cx="460" cy="50" r="4" fill="var(--accent-purple)" stroke="var(--bg-secondary)" strokeWidth="2" />

                  {/* X Axis Labels */}
                  <text x="60" y="216" fill="var(--text-muted)" fontSize="10" textAnchor="middle">Sprint 1</text>
                  <text x="180" y="216" fill="var(--text-muted)" fontSize="10" textAnchor="middle">Sprint 2</text>
                  <text x="300" y="216" fill="var(--text-muted)" fontSize="10" textAnchor="middle">Sprint 3</text>
                  <text x="420" y="216" fill="var(--text-muted)" fontSize="10" textAnchor="middle">Sprint 4</text>
                  <text x="460" y="216" fill="var(--text-muted)" fontSize="10" textAnchor="middle">Sprint 5</text>
                </svg>
              </div>
            </div>

            <div className="chart-card">
              <h3>Project Status Distribution</h3>
              <div className="chart-container" style={{ display: "flex", justifyContent: "space-around", alignItems: "center" }}>
                <svg width="180" height="180" viewBox="0 0 180 180">
                  {/* Gray background track */}
                  <circle cx="90" cy="90" r="70" fill="none" stroke="var(--border-color)" strokeWidth="16" />
                  
                  {/* On Track - 60% */}
                  <circle cx="90" cy="90" r="70" fill="none" stroke="var(--status-on-track)" strokeWidth="16" 
                          strokeDasharray="264 440" strokeDashoffset="0" strokeLinecap="round" transform="rotate(-90 90 90)" />

                  {/* Moderate Risk - 25% */}
                  <circle cx="90" cy="90" r="70" fill="none" stroke="var(--status-warning)" strokeWidth="16" 
                          strokeDasharray="110 440" strokeDashoffset="-264" strokeLinecap="round" transform="rotate(-90 90 90)" />

                  {/* High Risk - 15% */}
                  <circle cx="90" cy="90" r="70" fill="none" stroke="var(--status-danger)" strokeWidth="16" 
                          strokeDasharray="66 440" strokeDashoffset="-374" strokeLinecap="round" transform="rotate(-90 90 90)" />
                  
                  {/* Center Text */}
                  <text x="90" y="85" fill="var(--text-primary)" fontSize="20" fontWeight="800" textAnchor="middle">12</text>
                  <text x="90" y="105" fill="var(--text-muted)" fontSize="10" fontWeight="600" textAnchor="middle">Projects</text>
                </svg>

                <div style={{ display: "flex", flexDirection: "column", gap: "12px" }}>
                  <div style={{ display: "flex", alignItems: "center", gap: "8px" }}>
                    <div style={{ width: "12px", height: "12px", borderRadius: "50%", backgroundColor: "var(--status-on-track)" }} />
                    <span style={{ fontSize: "0.85rem", color: "var(--text-secondary)", fontWeight: 500 }}>On Track (60%)</span>
                  </div>
                  <div style={{ display: "flex", alignItems: "center", gap: "8px" }}>
                    <div style={{ width: "12px", height: "12px", borderRadius: "50%", backgroundColor: "var(--status-warning)" }} />
                    <span style={{ fontSize: "0.85rem", color: "var(--text-secondary)", fontWeight: 500 }}>Moderate (25%)</span>
                  </div>
                  <div style={{ display: "flex", alignItems: "center", gap: "8px" }}>
                    <div style={{ width: "12px", height: "12px", borderRadius: "50%", backgroundColor: "var(--status-danger)" }} />
                    <span style={{ fontSize: "0.85rem", color: "var(--text-secondary)", fontWeight: 500 }}>High Risk (15%)</span>
                  </div>
                </div>
              </div>
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