from pydantic import BaseModel

class PredictionOutput(BaseModel):

    sprint_velocity: float

    task_completion_rate: float

    team_utilization: float

    days_remaining: int

    delay_probability: float

    risk_status: str

    recommendation: str