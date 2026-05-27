import React from "react";
import "./Sidebar.css";

function Sidebar() {
  return (
    <div className="sidebar">
      <h2 className="logo">PIM</h2>

      <ul className="menu">
        <li>Dashboard</li>
        <li>Projects</li>
        <li>Sprints</li>
        <li>Tasks</li>
        <li>Resources</li>
        <li>Analytics</li>
        <li>Delay Risk</li>
        <li>Notifications</li>
        <li>Settings</li>
      </ul>
    </div>
  );
}

export default Sidebar;