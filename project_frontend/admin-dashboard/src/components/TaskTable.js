import React from "react";
import "./TaskTable.css";

function TaskTable() {
  const tasks = [
    {
      id: 1,
      task: "Login API",
      priority: "High",
      deadline: "Aug 20",
      status: "In Progress",
    },
    {
      id: 2,
      task: "Dashboard UI",
      priority: "Medium",
      deadline: "Aug 23",
      status: "Pending",
    },
    {
      id: 3,
      task: "Socket.IO Setup",
      priority: "High",
      deadline: "Aug 25",
      status: "Completed",
    },
  ];

  return (
    <div className="task-table-container">
      <h2>My Tasks</h2>

      <table className="task-table">
        <thead>
          <tr>
            <th>Task</th>
            <th>Priority</th>
            <th>Deadline</th>
            <th>Status</th>
          </tr>
        </thead>

        <tbody>
          {tasks.map((task) => (
            <tr key={task.id}>
              <td>{task.task}</td>
              <td>{task.priority}</td>
              <td>{task.deadline}</td>
              <td>{task.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TaskTable;