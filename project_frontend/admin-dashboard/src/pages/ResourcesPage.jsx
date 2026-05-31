import React, { useEffect, useState } from "react";
import api from "../services/api";
import MainLayout from "../layouts/MainLayout";

function ResourcesPage() {

    const [resources, setResources] = useState([]);

    const [showForm, setShowForm] = useState(false);

    const [users, setUsers] = useState([]);

    const [projects, setProjects] = useState([]);

    const [formData, setFormData] = useState({
        userId: "",
        projectId: "",
        utilizationPct: 0,
        availability: "AVAILABLE"
    });

    useEffect(() => {

        api.get("/resources")
            .then((response) => {
                setResources(response.data);
            })
            .catch((error) => {
                console.error(error);
            });

        api.get("/users")
            .then((response) => {
                setUsers(response.data);
            })
            .catch(console.error);

        api.get("/projects")
            .then((response) => {
                setProjects(response.data);
            })
            .catch(console.error);

    }, []);

    const handleSubmit = (e) => {

        e.preventDefault();

        api.post("/resources", formData)

            .then((response) => {

                setResources([
                    ...resources,
                    response.data
                ]);

                setShowForm(false);

                setFormData({
                    userId: "",
                    projectId: "",
                    utilizationPct: 0,
                    availability: "AVAILABLE"
                });

            })

            .catch(console.error);
    };

    return (
        <MainLayout>

            <h1>Resources</h1>

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
                    : "+ Create Resource"}
            </button>

            {showForm && (

                <form
                    onSubmit={handleSubmit}
                    style={{
                        border: "1px solid #ccc",
                        padding: "20px",
                        marginBottom: "20px",
                        borderRadius: "8px"
                    }}
                >

                    <h2>Create Resource</h2>

                    <select
                        value={formData.userId}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                userId: e.target.value
                            })
                        }
                    >

                        <option value="">
                            Select User
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

                    <select
                        value={formData.projectId}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                projectId: e.target.value
                            })
                        }
                    >

                        <option value="">
                            Select Project
                        </option>

                        {projects.map(project => (

                            <option
                                key={project.projectId}
                                value={project.projectId}
                            >
                                {project.name}
                            </option>

                        ))}

                    </select>

                    <br /><br />

                    <input
                        type="number"
                        placeholder="Utilization %"
                        value={formData.utilizationPct}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                utilizationPct: e.target.value
                            })
                        }
                    />

                    <br /><br />

                    <select
                        value={formData.availability}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                availability: e.target.value
                            })
                        }
                    >

                        <option value="AVAILABLE">
                            AVAILABLE
                        </option>

                        <option value="PARTIALLY_AVAILABLE">
                            PARTIALLY_AVAILABLE
                        </option>

                        <option value="UNAVAILABLE">
                            UNAVAILABLE
                        </option>

                    </select>

                    <br /><br />

                    <button type="submit">
                        Create Resource
                    </button>

                </form>

                )}

            {resources.length === 0 ? (

                <p>No Resources Found</p>

            ) : (

                resources.map((resource) => (

                    <div
                        key={resource.resourceId}
                        style={{
                            border: "1px solid #ccc",
                            padding: "10px",
                            marginBottom: "10px",
                            borderRadius: "8px"
                        }}
                    >

                        <h3>
                            {resource.userName}
                        </h3>

                        <p>
                            Project:
                            {" "}
                            {resource.projectName}
                        </p>

                        <p>
                            Utilization:
                            {" "}
                            {resource.utilizationPct}%
                        </p>

                        <p>
                            Availability:
                            {" "}
                            {resource.availability}
                        </p>

                    </div>

                ))

            )}

        </MainLayout>
    );
}

export default ResourcesPage;