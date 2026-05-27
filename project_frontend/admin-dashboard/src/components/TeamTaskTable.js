import React from "react";
import "./TeamTaskTable.css";

function TeamTaskTable() {
  const tasks = [
    {
      id: 1,
      developer: "Rahul",
      task: "Login API",
      priority: "High",
      status: "In Progress",
    },
    {
      id: 2,
      developer: "Priya",
      task: "Dashboard UI",
      priority: "Medium",
      status: "Pending",
    },
    {
      id: 3,
      developer: "Aman",
      task: "Socket Setup",
      priority: "High",
      status: "Completed",
    },
  ];

  return (
    <div className="team-task-container">
      <h2>Team Tasks</h2>

      <table className="team-task-table">
        <thead>
          <tr>
            <th>Developer</th>
            <th>Task</th>
            <th>Priority</th>
            <th>Status</th>
          </tr>
        </thead>

        <tbody>
          {tasks.map((task) => (
            <tr key={task.id}>
              <td>{task.developer}</td>
              <td>{task.task}</td>
              <td>{task.priority}</td>
              <td>{task.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TeamTaskTable;