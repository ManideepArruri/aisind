import React, { useEffect, useState } from "react";
import "./RecentProjects.css";
import api from "../services/api";

function RecentProjects() {

  const [projects, setProjects] = useState([]);

  useEffect(() => {

    api.get("/projects")
      .then((response) => {
        setProjects(response.data);
      })
      .catch((error) => {
        console.error(error);
      });

  }, []);

  return (
    <div className="projects-container">

      <h2>Recent Projects</h2>

      {projects.length === 0 ? (
        <p>No Projects Found</p>
      ) : (
        projects.map((project) => (
          <div key={project.projectId}>

            <h4>{project.name}</h4>

            <p>
              Manager: {project.managerName}
            </p>

            <p>
              Status: {project.status}
            </p>

          </div>
        ))
      )}

    </div>
  );
}

export default RecentProjects;