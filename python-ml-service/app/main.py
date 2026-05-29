from fastapi import FastAPI
from app.api.predict import router as predict_router
from app.api.etl import router as etl_router
from app.api.analytics import router as analytics_router

app = FastAPI(title="Python Analytics & ML Service")

@app.get("/health")
def health_check():
    return {"status": "OK"}

app.include_router(predict_router)
app.include_router(etl_router)
app.include_router(analytics_router)