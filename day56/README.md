# Day 56 – Prim’s Minimum Spanning Tree (MST)

## 🎯 Objective
Implement **Prim’s Algorithm** for finding the **Minimum Spanning Tree (MST)** of a weighted undirected graph.

---

## 🧩 Concepts Covered
- Priority Queue (Min-Heap) for edge selection
- Greedy MST approach
- Comparison with Kruskal’s MST

---

## 🧠 Algorithm Summary
1. Start from an arbitrary node (0 here).
2. Use a **Priority Queue** to always pick the smallest edge leading to a new node.
3. Continue until all vertices are included.
4. Track visited vertices to prevent cycles.

---

## 🧮 Time & Space
- **Time Complexity:** O(E log V)
- **Space Complexity:** O(V + E)

---

## 🧾 Output Example
