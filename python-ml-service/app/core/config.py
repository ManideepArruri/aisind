from pathlib import Path

class Settings:
    BASE_DIR = Path(__file__).resolve().parent.parent.parent
    DATA_DIR = BASE_DIR / "app" / "data"
    PREDICTION_MODE = "ML"  # or "ML"
    MODEL_PATH = DATA_DIR / "delay_risk_model.pkl"
    PROCESSED_CSV = DATA_DIR / "processed_project_metrics.csv"

settings = Settings()
