# Day 51 — Disjoint Set Union (Union-Find)

### 📘 Overview
Disjoint Set Union (DSU), also called Union-Find, is a data structure that tracks a set of elements partitioned into disjoint subsets.  
It provides two primary operations:

- **find(x)**: Determines which subset element `x` belongs to.
- **union(x, y)**: Merges the sets containing `x` and `y`.

### ⚙️ Implementation Features
- **Path Compression** (Optimizes `find`).
- **Union by Rank** (Optimizes `union`).
- Ensures near constant time operations — *amortized O(α(N))*, where α is the inverse Ackermann function.

### 🧩 Applications
- Kruskal’s Minimum Spanning Tree
- Detecting Cycles in Undirected Graphs
- Network Connectivity
- Cluster Formation

### 🧠 Example Output
