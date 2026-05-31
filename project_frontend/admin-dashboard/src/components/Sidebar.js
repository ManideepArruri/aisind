import React from "react";
import "./Sidebar.css";
import { Link } from "react-router-dom";

function Sidebar() {
  return (
    <div className="sidebar">
      <h2 className="logo">PIM</h2>

      <ul className="menu">

        <li>
          <Link to="/dashboard">Dashboard</Link>
        </li>

        <li>
          <Link to="/projects">Projects</Link>
        </li>

        <li>
          <Link to="/sprints">Sprints</Link>
        </li>

        <li>
          <Link to="/tasks">Tasks</Link>
        </li>

        <li>
          <Link to="/resources">Resources</Link>
        </li>

        <li>
          <Link to="/analytics">Analytics</Link>
        </li>

        <li>
          <Link to="/delay-risk">Delay Risk</Link>
        </li>

        <li>
          <Link to="/notifications">Notifications</Link>
        </li>

        <li>
          <Link to="/settings">Settings</Link>
        </li>

      </ul>
    </div>
  );
}

export default Sidebar;