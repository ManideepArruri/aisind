
import React from "react";
import { Link } from "react-router-dom";
import "./UserSidebar.css";

function UserSidebar() {
  return (
    <div className="user-sidebar">
      <h2 className="user-logo">PIM</h2>

      <ul className="user-menu">
        <li>
          <Link to="/dashboard/user">Dashboard</Link>
        </li>

        <li>
          <Link to="/tasks">My Tasks</Link>
        </li>

        <li>
          <Link to="/sprints">Sprint Progress</Link>
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

export default UserSidebar;