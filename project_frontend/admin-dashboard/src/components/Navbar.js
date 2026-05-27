import React from "react";
import "./Navbar.css";

function Navbar({
  role = "Admin",
}) {
  return (
    <div className="navbar">
      <input
        type="text"
        placeholder="Search projects..."
      />

      <div className="nav-right">
        <span className="notification">
          🔔
        </span>

        <span className="admin">
          {role}
        </span>
      </div>
    </div>
  );
}

export default Navbar;