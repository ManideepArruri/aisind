from apps.models.prediction_input import PredictionInput

def get_dummy_prediction(input_data: PredictionInput) -> dict:
    # For Day 1, return a fixed dummy response
    return {
        "delay_probability": 50,
        "status": "On Track (dummy)"
    }
