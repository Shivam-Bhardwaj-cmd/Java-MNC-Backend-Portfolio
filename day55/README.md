# 🌲 Day 55: Kruskal’s Minimum Spanning Tree (MST)

## 🧩 Overview
Kruskal’s Algorithm finds the **Minimum Spanning Tree (MST)** of a **connected, weighted, undirected graph** using the **Disjoint Set Union (Union-Find)** data structure.

It ensures no cycles form and that the total weight of edges is minimized.

---

## 🧠 Steps
1. Sort all edges by weight.
2. Initialize Disjoint Set for all vertices.
3. Iterate over edges:
   - If including an edge doesn’t form a cycle → Add it to MST.
   - Else, skip it.
4. Stop when MST has `V-1` edges.

---

## 📂 Files
- `DisjointSet.java` → Union-Find implementation.
- `KruskalMST.java` → Kruskal’s MST algorithm.
- `README.md` → Concept + usage.

---

## 🚀 Example Output
