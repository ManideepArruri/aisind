import pandas as pd
import numpy as np
import random
from faker import Faker

fake = Faker()

NUM_PROJECTS = 1000
SPRINTS_PER_PROJECT = 5

# -----------------------------
# 1. PROJECT DATA
# -----------------------------
project_ids = list(range(1, NUM_PROJECTS + 1))

project_data = {
    "project_id": project_ids,
    "project_name": [fake.bs().title() for _ in project_ids],
    "days_remaining": np.random.randint(1, 60, NUM_PROJECTS),
    "project_manager": [fake.name() for _ in project_ids],
    "team_size": np.random.randint(3, 15, NUM_PROJECTS)
}

project_df = pd.DataFrame(project_data)
project_df.to_csv("data/project_data.csv", index=False)

# -----------------------------
# 2. SPRINT VELOCITY DATA
# -----------------------------
rows = []
for pid in project_ids:
    base_velocity = np.random.randint(20, 60)
    for sprint in range(1, SPRINTS_PER_PROJECT + 1):
        velocity = max(5, int(np.random.normal(base_velocity, 10)))
        rows.append([pid, sprint, velocity])

sprint_df = pd.DataFrame(rows, columns=["project_id", "sprint_id", "velocity"])
sprint_df.to_csv("data/sprint_velocity.csv", index=False)

# -----------------------------
# 3. TASK COMPLETION DATA
# -----------------------------
completed = np.random.randint(20, 200, NUM_PROJECTS)
total = completed + np.random.randint(0, 100, NUM_PROJECTS)

task_df = pd.DataFrame({
    "project_id": project_ids,
    "completed_tasks": completed,
    "total_tasks": total
})
task_df.to_csv("data/task_completion.csv", index=False)

# -----------------------------
# 4. RESOURCE UTILIZATION DATA
# -----------------------------
util_df = pd.DataFrame({
    "project_id": project_ids,
    "avg_utilization_pct": np.random.randint(60, 100, NUM_PROJECTS)
})
util_df.to_csv("data/resource_utilization.csv", index=False)

print("Synthetic datasets generated successfully!")
