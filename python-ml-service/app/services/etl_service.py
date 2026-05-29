import pandas as pd
from app.core.config import settings

def run_etl():
    data_dir = settings.DATA_DIR

    project_df = pd.read_csv(data_dir / "project_data.csv")
    sprint_df = pd.read_csv(data_dir / "sprint_velocity.csv")
    task_df = pd.read_csv(data_dir / "task_completion.csv")
    util_df = pd.read_csv(data_dir / "resource_utilization.csv")

    # Aggregate sprint velocity per project
    sprint_agg = (
        sprint_df
        .groupby("project_id")["velocity"]
        .mean()
        .reset_index()
        .rename(columns={"velocity": "avg_velocity"})
    )

    # Compute completion rate
    task_df["completion_rate"] = (
        task_df["completed_tasks"] / task_df["total_tasks"] * 100
    )

    # Merge all into one metrics table
    merged = (
        project_df
        .merge(sprint_agg, on="project_id", how="left")
        .merge(task_df[["project_id", "completed_tasks", "total_tasks", "completion_rate"]],
               on="project_id", how="left")
        .merge(util_df, on="project_id", how="left")
    )

    # Simple synthetic "delayed_flag" for ML (you can tweak this rule)
    merged["delayed_flag"] = (
        (merged["completion_rate"] < 70) |
        (merged["avg_utilization_pct"] > 90) |
        (merged["days_remaining"] < 5)
    ).astype(int)

    merged.to_csv(settings.PROCESSED_CSV, index=False)

    return {
        "rows": len(merged),
        "path": str(settings.PROCESSED_CSV)
    }
