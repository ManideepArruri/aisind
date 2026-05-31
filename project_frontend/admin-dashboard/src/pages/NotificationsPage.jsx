import React, { useEffect, useState } from "react";
import api from "../services/api";
import MainLayout from "../layouts/MainLayout";

function NotificationsPage() {

    const [notifications, setNotifications] =
        useState([]);

    useEffect(() => {

        api.get("/predictions")
            .then(res => {
                setNotifications(res.data);
            })
            .catch(err => {
                console.error(err);
            });

    }, []);

    return (
        <MainLayout>

            <h1>Notifications</h1>

            {notifications.length === 0 ? (

                <p>No Notifications</p>

            ) : (

                notifications.map(item => (

                    <div
                        key={item.predictionId}
                        style={{
                            border: "1px solid #ccc",
                            padding: "12px",
                            marginBottom: "10px",
                            borderRadius: "8px"
                        }}
                    >

                        <h3>
                            {item.riskStatus}
                        </h3>

                        <p>
                            Project:
                            {" "}
                            {item.projectName}
                        </p>

                        <p>
                            {item.recommendation}
                        </p>

                        <p>
                            Generated:
                            {" "}
                            {item.generatedAt}
                        </p>

                    </div>

                ))

            )}

        </MainLayout>
    );
}

export default NotificationsPage;