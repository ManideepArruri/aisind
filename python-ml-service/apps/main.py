from fastapi import FastAPI
from apps.api.predict import router as predict_router

apps = FastAPI(
    title="Project Intelligence ML Service",
    version="1.0.0"
)

@apps.get("/health")
def health_check():
    return {"status": "OK"}

apps.include_router(predict_router)
