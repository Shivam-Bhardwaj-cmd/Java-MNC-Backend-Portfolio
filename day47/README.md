# 🔗 Day 47 — Disjoint Set Applications: Cycle Detection & Kruskal’s MST

## 📘 Overview
Building on Day 46’s Disjoint Set, we now apply it to **real graph problems**:
1. **Cycle Detection (Undirected Graphs)**  
2. **Kruskal’s Minimum Spanning Tree (MST)**

These problems are vital in system design — e.g., detecting redundant links or minimizing network cost.

---

## 🧠 Key Concepts
- **Cycle Detection**: Before connecting two vertices, check if they share the same parent.
- **Kruskal’s Algorithm**:
  - Sort all edges by weight.
  - Pick the smallest edge that doesn’t form a cycle.
  - Repeat until (V−1) edges are included.

---

## ⚙️ Time Complexity
| Operation | Complexity |
|------------|-------------|
| `find` / `union` | O(α(n)) ≈ Constant |
| Sorting Edges | O(E log E) |
| **Total (Kruskal’s)** | O(E log E) |

---

## 🧩 Output Example
### ✅ Cycle Detection
