import pandas as pd
from app.core.config import settings

def get_sprint_velocity_trend():
    data_dir = settings.DATA_DIR
    sprint_df = pd.read_csv(data_dir / "sprint_velocity.csv")

    grouped = (
        sprint_df
        .groupby(["project_id", "sprint_id"])["velocity"]
        .mean()
        .reset_index()
    )

    return grouped.to_dict(orient="records")

def get_at_risk_projects():
    processed = pd.read_csv(settings.PROCESSED_CSV)

    risky = processed[
        (processed["completion_rate"] < 70) |
        (processed["avg_utilization_pct"] > 90)
    ]

    return risky[[
        "project_id",
        "project_name",
        "completion_rate",
        "avg_utilization_pct",
        "days_remaining"
    ]].to_dict(orient="records")

def get_delay_trends():
    processed = pd.read_csv(settings.PROCESSED_CSV)

    # Example: group by days_remaining bucket
    processed["days_bucket"] = pd.cut(
        processed["days_remaining"],
        bins=[0, 7, 14, 30, 60],
        labels=["0-7", "8-14", "15-30", "31-60"]
    )

    trend = (
        processed
        .groupby("days_bucket")["delayed_flag"]
        .mean()
        .reset_index()
        .rename(columns={"delayed_flag": "delay_rate"})
    )

    return trend.to_dict(orient="records")
