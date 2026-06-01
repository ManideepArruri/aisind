import React, { useEffect, useState } from "react";
import api from "../services/api";
import MainLayout from "../layouts/MainLayout";
import "./PredictionsPage.css";

function PredictionsPage() {

    const [predictions, setPredictions] = useState([]);

    useEffect(() => {
        api.get("/predictions")
            .then((response) => {
                setPredictions(response.data);
                console.log(response);
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);

    const getRiskClass = (status) => {
        if (!status) return "on-track";
        return status.toLowerCase().replace("_", "-");
    };

    const formatRiskStatus = (status) => {
        if (!status) return "";
        return status.replace("_", " ");
    };

    return (
        <MainLayout>
            <h1 style={{ marginBottom: "8px" }}>Delay Risk Predictions</h1>
            <p style={{ color: "var(--text-muted)", marginBottom: "24px" }}>
                AI-driven analysis forecasting project delays and recommendations.
            </p>

            {predictions.length === 0 ? (
                <div className="prediction-card" style={{ padding: "40px", textAlign: "center" }}>
                    <p style={{ color: "var(--text-muted)" }}>No Predictions Found</p>
                </div>
            ) : (
                <div className="predictions-grid">
                    {predictions.map((prediction) => {
                        const riskClass = getRiskClass(prediction.riskStatus);
                        return (
                            <div
                                key={prediction.predictionId}
                                className={`prediction-card ${riskClass}`}
                            >
                                <div className="prediction-header">
                                    <span className="prediction-project-name">
                                        {prediction.projectName || `Project #${prediction.projectId}`}
                                    </span>
                                    <span className={`status-badge ${riskClass}`}>
                                        {formatRiskStatus(prediction.riskStatus)}
                                    </span>
                                </div>

                                <div className="prediction-detail">
                                    <span className="prediction-label">Delay Probability:</span>
                                    <span className="prediction-value" style={{ 
                                        color: prediction.riskStatus === "HIGH_RISK" ? "var(--status-danger)" : 
                                               prediction.riskStatus === "MODERATE_RISK" ? "var(--status-warning)" : "var(--status-on-track)"
                                    }}>
                                        {(prediction.delayProbability * 100).toFixed(0)}%
                                    </span>
                                </div>

                                <div className="prediction-detail">
                                    <span className="prediction-label">Generated At:</span>
                                    <span className="prediction-value" style={{ fontSize: "0.85rem", color: "var(--text-muted)" }}>
                                        {prediction.generatedAt ? new Date(prediction.generatedAt).toLocaleString() : "N/A"}
                                    </span>
                                </div>

                                <div className="recommendation-box">
                                    <span className="recommendation-label">AI Recommendation</span>
                                    {prediction.recommendation}
                                </div>
                            </div>
                        );
                    })}
                </div>
            )}
        </MainLayout>
    );
}

export default PredictionsPage;