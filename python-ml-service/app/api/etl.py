from fastapi import APIRouter
from app.services.etl_service import run_etl
from app.services.ml_service import train_ml_model

router = APIRouter(prefix="/etl", tags=["ETL"])

@router.post("/process")
def process_etl():
    result = run_etl()
    return {"message": "ETL completed", "details": result}

@router.post("/train-ml")
def train_model():
    result = train_ml_model()
    return result
