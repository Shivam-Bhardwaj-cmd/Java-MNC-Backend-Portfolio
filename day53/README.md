# 🧠 Day 53: Dynamic Programming on DAGs (Topological-based)

## 🔍 Overview
This day covers **Dynamic Programming on Directed Acyclic Graphs (DAGs)** — a powerful technique that combines graph traversal and DP logic to compute:
- Longest paths
- Path counts
- Scheduling or ordering optimizations

These are essential for backend systems such as:
- Job scheduling
- Build dependency resolution
- Workflow orchestration (Airflow, Jenkins DAGs)

---

## 🧩 Files
- `DAGLongestPathDP.java` → Finds longest weighted path from a source using Topological Sort + DP.
- `DAGPathCountDP.java` → Counts number of unique paths from source to destination using DP.

---

## ⚙️ How to Run
```bash
javac DAGLongestPathDP.java
java DAGLongestPathDP

javac DAGPathCountDP.java
java DAGPathCountDP
