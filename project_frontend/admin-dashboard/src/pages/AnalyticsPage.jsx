import React, { useEffect, useState } from "react";
import api from "../services/api";
import MainLayout from "../layouts/MainLayout";

function AnalyticsPage() {

    const [projectCount, setProjectCount] = useState(0);
    const [taskCount, setTaskCount] = useState(0);
    const [sprintCount, setSprintCount] = useState(0);
    const [resourceCount, setResourceCount] = useState(0);
    const [averageDelay, setAverageDelay] = useState(0);
    const [highRiskCount, setHighRiskCount] = useState(0);
    const [mediumRiskCount, setMediumRiskCount] = useState(0);
    const [lowRiskCount, setLowRiskCount] = useState(0);

    useEffect(() => {

        api.get("/projects")
            .then(res => setProjectCount(res.data.length));

        api.get("/tasks")
            .then(res => setTaskCount(res.data.length));

        api.get("/sprints")
            .then(res => setSprintCount(res.data.length));

        api.get("/resources")
            .then(res => setResourceCount(res.data.length));

        api.get("/predictions")
            .then(res => {

                const predictions = res.data;

                if (predictions.length > 0) {

                    const avg =
                        predictions.reduce(
                            (sum, p) =>
                                sum + p.delayProbability,
                            0
                        ) / predictions.length;

                    setAverageDelay(
                        (avg * 100).toFixed(0)
                    );

                    setHighRiskCount(
                        predictions.filter(
                            p => p.riskStatus === "HIGH_RISK"
                        ).length
                    );

                    setMediumRiskCount(
                        predictions.filter(
                            p => p.riskStatus === "MEDIUM_RISK"
                        ).length
                    );

                    setLowRiskCount(
                        predictions.filter(
                            p => p.riskStatus === "LOW_RISK"
                        ).length
                    );
                }
            });

    }, []);

    return (
        <MainLayout>

            <h1>Analytics Dashboard</h1>

            <div
                style={{
                    display: "grid",
                    gridTemplateColumns: "repeat(2, 1fr)",
                    gap: "20px",
                    marginTop: "20px"
                }}
            >

                <div style={cardStyle}>
                    <h3>Total Projects</h3>
                    <h2>{projectCount}</h2>
                </div>

                <div style={cardStyle}>
                    <h3>Total Tasks</h3>
                    <h2>{taskCount}</h2>
                </div>

                <div style={cardStyle}>
                    <h3>Total Sprints</h3>
                    <h2>{sprintCount}</h2>
                </div>

                <div style={cardStyle}>
                    <h3>Total Resources</h3>
                    <h2>{resourceCount}</h2>
                </div>

                <div style={cardStyle}>
                    <h3>Average Delay Risk</h3>
                    <h2>{averageDelay}%</h2>
                </div>

                <div style={cardStyle}>
                    <h3>High Risk Projects</h3>
                    <h2>{highRiskCount}</h2>
                </div>

                <div style={cardStyle}>
                    <h3>Medium Risk Projects</h3>
                    <h2>{mediumRiskCount}</h2>
                </div>

                <div style={cardStyle}>
                    <h3>Low Risk Projects</h3>
                    <h2>{lowRiskCount}</h2>
                </div>

            </div>

        </MainLayout>
    );
}

const cardStyle = {
    border: "1px solid #ddd",
    borderRadius: "10px",
    padding: "20px",
    textAlign: "center"
};

export default AnalyticsPage;