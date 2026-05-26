from fastapi import APIRouter
from apps.models.prediction_input import PredictionInput
from apps.services.prediction_service import get_dummy_prediction

router = APIRouter()

@router.post("/predict")
def predict_delay(input_data: PredictionInput):
    result = get_dummy_prediction(input_data)
    return result
