# 🧮 Day 49 — All-Pairs Shortest Path Algorithms (Floyd–Warshall + Johnson’s Algorithm)

## 📘 Overview
Today, we focus on algorithms that compute **shortest paths between every pair of vertices** — foundational in distributed systems, networking, and compiler design.

---

## 🧠 Algorithms Implemented:

### 1️⃣ Floyd–Warshall Algorithm
- Dynamic Programming approach.
- Works on both directed and undirected graphs.
- Handles **negative weights (no negative cycles)**.
- Time Complexity: **O(V³)**.
- Real-world Use: Database joins, traffic analysis, and network latency optimization.

### 2️⃣ Johnson’s Algorithm
- Efficient for sparse graphs.
- Combines **Bellman-Ford** for reweighting and **Dijkstra** for fast shortest-path computation.
- Handles negative weights.
- Time Complexity: **O(V² log V + V × E)**.
- Real-world Use: Routing, compiler optimization, and distributed systems.

---

## ⚙️ Run Instructions

Compile and run either class independently:
```bash
javac com/dsa/graphs/shortestpath/FloydWarshallAlgorithm.java
java com.dsa.graphs.shortestpath.FloydWarshallAlgorithm
