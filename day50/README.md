# 🧠 Day 50 — DP on Graphs (DAG Based)

## 🎯 Topics Covered
- Shortest Path in DAG using Topological Sort
- Longest Path in DAG (for Job Scheduling / Build Systems)
- Counting Paths in DAG using DP + DFS Memoization

## 📚 Key Concepts
- DAG = Directed Acyclic Graph
- Used in dependency resolution, build pipelines, and compiler scheduling.
- Topological order ensures that each node is processed after its dependencies.

## ⚙️ Files
- `DAGShortestPathDP.java` → Shortest Path using DP + Topo Sort
- `DAGLongestPath.java` → Longest Path in DAG
- `DAGPathCount.java` → Total number of paths from src → dest

## 🧩 Example Use Cases
- Task Scheduling (dependencies)
- Build Ordering (Gradle/Maven)
- Course Prerequisite Ordering
