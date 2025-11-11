# Day 58 – Bellman-Ford Algorithm (Single Source Shortest Path with Negative Weights)

## 🎯 Objective
Implement **Bellman-Ford Algorithm** to compute the shortest path from a single source vertex to all other vertices in a weighted directed graph — capable of handling **negative edge weights** and detecting **negative weight cycles**.

---

## 🧩 Key Concepts
- Works even with **negative edge weights**
- Detects **negative weight cycles**
- Based on **Dynamic Programming**
- Slower than Dijkstra but more general-purpose

---

## ⚙️ Steps
1. Initialize distances from the source vertex to all others as infinite.
2. Relax all edges **V-1 times** to update shortest paths.
3. Run one extra iteration to check for **negative weight cycles**.

---

## 🧮 Complexity
| Metric | Value |
|--------|--------|
| **Time Complexity** | O(V × E) |
| **Space Complexity** | O(V) |

---

## 🧠 Real-World Applications
- **Financial systems** (detecting arbitrage opportunities)
- **Telecom routing** (cost-based routing algorithms)
- **Compiler dependency analysis** (detecting circular dependencies)

---

## 🧾 Example Output
Vertex Distance from Source (0):
To 0 -> 0
To 1 -> -1
To 2 -> 2
To 3 -> -2
To 4 -> 1