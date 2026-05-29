import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
import joblib

from app.core.config import settings

def train_ml_model():
    df = pd.read_csv(settings.PROCESSED_CSV)

    # Features and target (you can add more features)
    X = df[["completion_rate", "avg_utilization_pct", "avg_velocity", "days_remaining"]]
    y = df["delayed_flag"]

    X_train, X_test, y_train, y_test = train_test_split(
        X, y, test_size=0.2, random_state=42
    )

    model = LogisticRegression(max_iter=1000)
    model.fit(X_train, y_train)

    joblib.dump(model, settings.MODEL_PATH)

    score = model.score(X_test, y_test)

    return {
        "message": "Model trained",
        "model_path": str(settings.MODEL_PATH),
        "test_accuracy": score
    }

def ml_predict(metrics: dict):
    model = joblib.load(settings.MODEL_PATH)

    X = [[
        metrics["task_completion_rate"],
        metrics["team_utilization"],
        metrics["sprint_velocity"],
        metrics["days_remaining"]
    ]]

    prob = model.predict_proba(X)[0][1] * 100
    prob_int = int(prob)

    status = "On Track"
    if prob_int >= 80:
        status = "High Risk / Delayed"
    elif prob_int >= 50:
        status = "Moderate Risk"
    elif prob_int >= 30:
        status = "Uncertain / Monitor"

    return {
        "delay_probability": prob_int,
        "status": status
    }
