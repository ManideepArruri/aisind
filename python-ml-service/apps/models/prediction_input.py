from pydantic import BaseModel

class PredictionInput(BaseModel):
    sprint_velocity: int
    task_completion_rate: int
    team_utilization: int
    days_remaining: int
