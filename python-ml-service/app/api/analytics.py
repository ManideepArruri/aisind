from fastapi import APIRouter
from app.services.analytics_service import (
    get_sprint_velocity_trend,
    get_at_risk_projects,
    get_delay_trends,
)

router = APIRouter(prefix="/analytics", tags=["Analytics"])

@router.get("/sprint-velocity")
def sprint_velocity():
    return get_sprint_velocity_trend()

@router.get("/at-risk-projects")
def at_risk_projects():
    return get_at_risk_projects()

@router.get("/delay-trends")
def delay_trends():
    return get_delay_trends()
