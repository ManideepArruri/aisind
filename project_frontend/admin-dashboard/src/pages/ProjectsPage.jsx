import React, { useEffect, useState } from "react";
import api from "../services/api";
import MainLayout from "../layouts/MainLayout";

function ProjectsPage() {

    const [projects, setProjects] = useState([]);

    const [users, setUsers] = useState([]);
    const [showForm, setShowForm] = useState(false);

    const [formData, setFormData] = useState({
        name: "",
        managerId: "",
        startDate: "",
        endDate: "",
        status: "ACTIVE",
        delayRiskScore: 0
    });

    useEffect(() => {

        api.get("/projects")
            .then((response) => {
                setProjects(response.data);
            })
            .catch((error) => {
                console.error(error);
            });

        api.get("/users")
            .then((response) => {
                setUsers(response.data);
            })
            .catch(console.error);
    }, []);

    const handleSubmit = (e) => {

        e.preventDefault();

        api.post("/projects", formData)

            .then((response) => {

                setProjects([
                    ...projects,
                    response.data
                ]);

                setShowForm(false);

                setFormData({
                    name: "",
                    managerId: "",
                    startDate: "",
                    endDate: "",
                    status: "ACTIVE",
                    delayRiskScore: 0
                });

            })

            .catch(console.error);
    };

    return (
        <MainLayout>

            <h1>Projects</h1>

            <button
                onClick={() =>
                    setShowForm(!showForm)
                }
                style={{
                    marginBottom: "20px"
                }}
            >
                {showForm
                    ? "Cancel"
                    : "+ Create Project"}
            </button>

            {showForm && (
            <form
                onSubmit={handleSubmit}
                style={{
                    border: "1px solid #ccc",
                    padding: "20px",
                    marginBottom: "20px"
                }}
            >

                <h2>Create Project</h2>

                <input
                    type="text"
                    placeholder="Project Name"
                    value={formData.name}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            name: e.target.value
                        })
                    }
                />

                <br /><br />

                <select
                    value={formData.managerId}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            managerId: e.target.value
                        })
                    }
                >

                    <option value="">
                        Select Manager
                    </option>

                    {users.map(user => (

                        <option
                            key={user.id}
                            value={user.id}
                        >
                            {user.name}
                        </option>

                    ))}

                </select>

                <br /><br />

                <input
                    type="date"
                    value={formData.startDate}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            startDate: e.target.value
                        })
                    }
                />

                <br /><br />

                <input
                    type="date"
                    value={formData.endDate}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            endDate: e.target.value
                        })
                    }
                />

                <br /><br />

                <input
                    type="number"
                    placeholder="Delay Risk Score"
                    value={formData.delayRiskScore}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            delayRiskScore: e.target.value
                        })
                    }
                />

                <br /><br />

                <button type="submit">
                    Create Project
                </button>

            </form>
            )}

            {projects.length === 0 ? (
                <p>No Projects Found</p>
            ) : (
                projects.map((project) => (

                    <div
                        key={project.projectId}
                        style={{
                            border: "1px solid #ccc",
                            padding: "10px",
                            marginBottom: "10px",
                            borderRadius: "8px"
                        }}
                    >

                        <h3>{project.name}</h3>

                        <p>
                            Manager: {project.managerName}
                        </p>

                        <p>
                            Status: {project.status}
                        </p>

                        <p>
                            Delay Risk Score: {project.delayRiskScore}
                        </p>

                    </div>

                ))
            )}

        </MainLayout>
    );
}

export default ProjectsPage;