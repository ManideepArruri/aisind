import React, { useEffect, useState } from "react";
import api from "../services/api";
import MainLayout from "../layouts/MainLayout";

function SprintsPage() {

    const [sprints, setSprints] = useState([]);

    const [showForm, setShowForm] = useState(false);

    const [projects, setProjects] = useState([]);

    const [formData, setFormData] = useState({
        projectId: "",
        sprintName: "",
        velocity: 0,
        startDate: "",
        endDate: "",
        status: "ACTIVE"
    });

    useEffect(() => {

        api.get("/sprints")
            .then((response) => {
                setSprints(response.data);
                console.log("SPRINTS:", response.data);
            })
            .catch((error) => {
                console.error(error);
            });

        api.get("/projects")
            .then(res => setProjects(res.data));

    }, []);

    const handleSubmit = (e) => {

        e.preventDefault();

        api.post("/sprints", formData)

            .then((response) => {

                setSprints([
                    ...sprints,
                    response.data
                ]);

                setShowForm(false);

                setFormData({
                    projectId: "",
                    sprintName: "",
                    velocity: 0,
                    startDate: "",
                    endDate: "",
                    status: "ACTIVE"
                });

            })

            .catch(console.error);
    };

    return (
        <MainLayout>
        <div>

            <h1>Sprints</h1>
            <button
                onClick={() => setShowForm(!showForm)}
            >
                {showForm
                    ? "Cancel"
                    : "+ Create Sprint"}
            </button>

            <br/>
            <br/>

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

                    <h2>Create Sprint</h2>

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
                        type="text"
                        placeholder="Sprint Name"
                        value={formData.sprintName}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                sprintName: e.target.value
                            })
                        }
                    />

                    <br /><br />

                    <input
                        type="number"
                        placeholder="Velocity"
                        value={formData.velocity}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                velocity: e.target.value
                            })
                        }
                    />

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

                    <select
                        value={formData.status}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                status: e.target.value
                            })
                        }
                    >

                        <option value="PLANNED">
                            PLANNED
                        </option>

                        <option value="ACTIVE">
                            ACTIVE
                        </option>

                        <option value="COMPLETED">
                            COMPLETED
                        </option>

                    </select>

                    <br /><br />

                    <button type="submit">
                        Create Sprint
                    </button>

                </form>

                )}

            {sprints.length === 0 ? (
                <p>No Sprints Found</p>
            ) : (
                sprints.map((sprint) => (

                    <div
    key={sprint.sprintId}
    style={{
        border: "1px solid #ccc",
        padding: "10px",
        marginBottom: "10px",
        borderRadius: "8px"
    }}
>

    <h3>{sprint.sprintName}</h3>

    <p>
        Project: {sprint.projectName}
    </p>

    <p>
        Velocity: {sprint.velocity}
    </p>

    <p>
        Status: {sprint.status}
    </p>

    <p>
        Start Date: {sprint.startDate}
    </p>

    <p>
        End Date: {sprint.endDate}
    </p>

</div>

                ))
            )}

        </div>
        </MainLayout>
    );
}

export default SprintsPage;