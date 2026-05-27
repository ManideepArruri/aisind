import React from "react";
import "./ManagerStatCard.css";

function ManagerStatCard({
  title,
  value,
}) {
  return (
    <div className="manager-stat-card">
      <h3>{title}</h3>
      <h2>{value}</h2>
    </div>
  );
}

export default ManagerStatCard;