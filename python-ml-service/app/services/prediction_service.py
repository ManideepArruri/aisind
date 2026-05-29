import pandas as pd
from pathlib import Path
from app.core.config import settings
from app.services.ml_service import ml_predict

DATA_DIR = settings.DATA_DIR

def load_project_metrics(project_id: int):
    # Load CSVs (each returns ONE value)
    sprint_df = pd.read_csv(DATA_DIR / "sprint_velocity.csv")
    task_df = pd.read_csv(DATA_DIR / "task_completion.csv")
    util_df = pd.read_csv(DATA_DIR / "resource_utilization.csv")
    proj_df = pd.read_csv(DATA_DIR / "project_data.csv")

    # Filter rows
    sprint_proj = sprint_df[sprint_df["project_id"] == project_id]
    task_proj = task_df[task_df["project_id"] == project_id]
    util_proj = util_df[util_df["project_id"] == project_id]
    proj_row = proj_df[proj_df["project_id"] == project_id]

    # Check if project exists
    if sprint_proj.empty or task_proj.empty or util_proj.empty or proj_row.empty:
        return None, f"Project ID {project_id} not found in CSV files."

    # Compute metrics
    avg_velocity = float(sprint_proj["velocity"].mean())
    completion_rate = float(task_proj["completed_tasks"].iloc[0] /
                            task_proj["total_tasks"].iloc[0] * 100)
    avg_utilization = float(util_proj["avg_utilization_pct"].iloc[0])
    days_remaining = int(proj_row["days_remaining"].iloc[0])

    metrics = {
        "sprint_velocity": avg_velocity,
        "task_completion_rate": completion_rate,
        "team_utilization": avg_utilization,
        "days_remaining": days_remaining
    }

    return metrics, None



def rule_based_prediction(metrics: dict):
    v = metrics["sprint_velocity"]
    c = metrics["task_completion_rate"]
    u = metrics["team_utilization"]

    if v > 50 and c > 80 and u < 85:
        return {"delay_probability": 10, "status": "On Track"}
    elif 30 <= v <= 50 and 60 <= c <= 80 and 85 <= u <= 95:
        return {"delay_probability": 50, "status": "Moderate Risk"}
    elif v < 30 and c < 60 and u > 95:
        return {"delay_probability": 85, "status": "High Risk / Delayed"}
    else:
        return {"delay_probability": 40, "status": "Uncertain / Monitor"}

def convert_to_python_types(data: dict):
    clean = {}
    for key, value in data.items():
        if hasattr(value, "item"):  # numpy types
            clean[key] = value.item()
        else:
            clean[key] = float(value) if isinstance(value, float) else value
    return clean


def get_prediction_for_project(project_id: int):
    metrics, err = load_project_metrics(project_id)
    if err:
        return {"error": err}

    # Convert numpy → python
    metrics = convert_to_python_types(metrics)

    if settings.PREDICTION_MODE == "ML":
        result = ml_predict(metrics)
    else:
        result = rule_based_prediction(metrics)

    result = convert_to_python_types(result)

    return {**metrics, **result}
