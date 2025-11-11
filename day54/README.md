# ⚙️ Day 54: Disjoint Set Union (Union-Find)

## 🧩 Overview
The **Disjoint Set Union (Union-Find)** data structure efficiently tracks elements that are divided into disjoint sets.  
It’s the backbone of many graph algorithms like **Kruskal’s MST**, **Cycle Detection**, and **Connected Components**.

---

## 📂 Files
- `DisjointSet.java` → Implements Union-Find with Path Compression + Union by Rank.
- `UnionFindCycleDetection.java` → Uses Union-Find to detect cycles in an undirected graph.

---

## 🚀 Key Concepts
1. **Find with Path Compression** → Flattens the tree structure for fast lookups.  
2. **Union by Rank/Size** → Keeps trees shallow by attaching smaller trees under bigger ones.  
3. **Cycle Detection** → When two vertices have the same root, adding the edge creates a cycle.

---

## 🧮 Example Output
