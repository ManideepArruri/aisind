from fastapi import APIRouter
from app.services.prediction_service import get_prediction_for_project

router = APIRouter(prefix="/predict", tags=["Prediction"])

@router.get("/{project_id}")
def predict_for_project(project_id: int):
    return get_prediction_for_project(project_id)
