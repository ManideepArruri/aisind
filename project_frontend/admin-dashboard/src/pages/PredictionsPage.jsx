import React, { useEffect, useState } from "react";
import api from "../services/api";
import MainLayout from "../layouts/MainLayout";

function PredictionsPage() {

    const [predictions, setPredictions] = useState([]);

    useEffect(() => {

        api.get("/predictions")
            .then((response) => {
                setPredictions(response.data);
                console.log(response)
            })
            .catch((error) => {
                console.error(error);
            });

    }, []);

    return (
        <MainLayout>

            <h1>Delay Risk Predictions</h1>

            {predictions.length === 0 ? (
                <p>No Predictions Found</p>
            ) : (
                predictions.map((prediction) => (

                    <div
                        key={prediction.predictionId}
                        style={{
                            border: "1px solid #ccc",
                            padding: "10px",
                            marginBottom: "10px",
                            borderRadius: "8px"
                        }}
                    >

                        <h3>
    {prediction.project?.name}
</h3>

<p>
    Delay Probability:
    {(prediction.delayProbability * 100).toFixed(0)}%
</p>

<p>
    Risk Status:
    {prediction.riskStatus}
</p>

<p>
    Recommendation:
    {prediction.recommendation}
</p>

<p>
    Generated At:
    {prediction.generatedAt}
</p>

                    </div>

                ))
            )}

        </MainLayout>
    );
}

export default PredictionsPage;