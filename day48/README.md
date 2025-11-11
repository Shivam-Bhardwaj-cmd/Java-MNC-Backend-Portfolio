# 🧮 Day 48 — Shortest Path Algorithms (DAG + Dijkstra + Bellman-Ford)

## 📘 Overview
This module covers **three foundational shortest path algorithms** essential for backend and system-level optimization.

### 🧠 Algorithms Implemented:
1. **DAGShortestPath.java**
   - Works only on Directed Acyclic Graphs (DAG)
   - Uses Topological Sorting
   - Time Complexity: O(V + E)
   - Real-world: Build order, Job Scheduling

2. **DijkstraShortestPath.java**
   - Greedy algorithm using Min-Heap
   - Works on graphs with non-negative weights
   - Time Complexity: O(E log V)
   - Real-world: GPS routing, Network packet routing

3. **BellmanFordShortestPath.java**
   - Works on graphs with negative weights
   - Detects negative weight cycles
   - Time Complexity: O(V × E)
   - Real-world: Financial transaction systems, currency arbitrage

---

## 🏁 Run Instructions

Each file has its own `main()` for standalone execution.

Example:
```bash
javac com/dsa/graphs/shortestpath/DijkstraShortestPath.java
java com.dsa.graphs.shortestpath.DijkstraShortestPath
