import React, { useEffect, useState } from "react";
import api from "../services/api";
import MainLayout from "../layouts/MainLayout";

function TasksPage() {

    const [tasks, setTasks] = useState([]);

    const [showForm, setShowForm] = useState(false);

    const [users, setUsers] = useState([]);

    const [sprints, setSprints] = useState([]);

    const [formData, setFormData] = useState({
        title: "",
        description: "",
        dueDate: "",
        status: "TODO",
        priority: "MEDIUM",
        storyPoints: 0,
        sprintId: "",
        assignedUserId: ""
    });

    useEffect(() => {

        api.get("/tasks")
            .then((response) => {
                setTasks(response.data);
                console.log("TASKS:", response.data);
            })
            .catch((error) => {
                console.error(error);
            });

        api.get("/users")
            .then((response) => {
                setUsers(response.data);
            })
            .catch(console.error);

        api.get("/sprints")
            .then((response) => {
                setSprints(response.data);
            })
            .catch(console.error);

    }, []);

    const handleSubmit = (e) => {

    e.preventDefault();

    api.post("/tasks", formData)

        .then((response) => {

            setTasks([
                ...tasks,
                response.data
            ]);

            setShowForm(false);

            setFormData({
                title: "",
                description: "",
                dueDate: "",
                status: "TODO",
                priority: "MEDIUM",
                storyPoints: 0,
                sprintId: "",
                assignedUserId: ""
            });

        })

        .catch(console.error);
};

    return (
        <MainLayout>

            <h1>Tasks</h1>

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
                    : "+ Create Task"}
            </button>

            <br />

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

                    <h2>Create Task</h2>

                    <input
                        type="text"
                        placeholder="Title"
                        value={formData.title}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                title: e.target.value
                            })
                        }
                    />

                    <br /><br />

                    <textarea
                        placeholder="Description"
                        value={formData.description}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                description: e.target.value
                            })
                        }
                    />

                    <br /><br />

                    <input
                        type="date"
                        value={formData.dueDate}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                dueDate: e.target.value
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

                        <option value="TODO">TODO</option>
                        <option value="IN_PROGRESS">IN_PROGRESS</option>
                        <option value="DONE">DONE</option>

                    </select>

                    <br /><br />

                    <select
                        value={formData.priority}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                priority: e.target.value
                            })
                        }
                    >

                        <option value="LOW">LOW</option>
                        <option value="MEDIUM">MEDIUM</option>
                        <option value="HIGH">HIGH</option>

                    </select>

                    <br /><br />

                    <input
                        type="number"
                        placeholder="Story Points"
                        value={formData.storyPoints}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                storyPoints: e.target.value
                            })
                        }
                    />

                    <br /><br />

                    <select
                        value={formData.sprintId}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                sprintId: e.target.value
                            })
                        }
                    >

                        <option value="">
                            Select Sprint
                        </option>

                        {sprints.map(sprint => (

                            <option
                                key={sprint.sprintId}
                                value={sprint.sprintId}
                            >
                                {sprint.sprintName}
                            </option>

                        ))}

                    </select>

                    <br /><br />

                    <select
                        value={formData.assignedUserId}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                assignedUserId: e.target.value
                            })
                        }
                    >

                        <option value="">
                            Assign User
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

                    <button type="submit">
                        Create Task
                    </button>

                </form>

                )}

            {tasks.length === 0 ? (
                <p>No Tasks Found</p>
            ) : (
                tasks.map((task) => (

                    <div
    key={task.taskId}
    style={{
        border: "1px solid #ccc",
        padding: "10px",
        marginBottom: "10px",
        borderRadius: "8px"
    }}
>

    <h3>{task.title}</h3>

    <p>
        Description: {task.description}
    </p>

    <p>
        Status: {task.status}
    </p>

    <p>
        Priority: {task.priority}
    </p>

    <p>
        Story Points: {task.storyPoints}
    </p>

    <p>
        Sprint: {task.sprintName}
    </p>

    <p>
        Assigned To: {task.assignedUserName}
    </p>

    <p>
        Due Date: {task.dueDate}
    </p>

</div>
                ))
            )}

        </MainLayout>
    );
}

export default TasksPage;