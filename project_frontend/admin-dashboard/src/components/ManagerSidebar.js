import React from "react";
import { Link } from "react-router-dom";
import "./ManagerSidebar.css";

function ManagerSidebar() {
  return (
    <div className="manager-sidebar">
      <h2 className="manager-logo">PIM</h2>

      <ul className="manager-menu">
        <li>
          <Link to="/dashboard/manager">
            Dashboard
          </Link>
        </li>

        <li>
          <Link to="/projects">
            Projects
          </Link>
        </li>

        <li>
          <Link to="/sprints">
            Sprint Management
          </Link>
        </li>

        <li>
          <Link to="/tasks">
            Team Tasks
          </Link>
        </li>

        <li>
          <Link to="/resources">
            Resources
          </Link>
        </li>

        <li>
          <Link to="/analytics">
            Analytics
          </Link>
        </li>

        <li>
          <Link to="/delay-risk">
            Delay Risk
          </Link>
        </li>

        <li>
          <Link to="/notifications">
            Notifications
          </Link>
        </li>

        <li>
          <Link to="/settings">
            Settings
          </Link>
        </li>
      </ul>
    </div>
  );
}

export default ManagerSidebar;