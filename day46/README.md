# 🧮 Day 46 - Disjoint Set (Union-Find)

## 📘 Overview
The **Disjoint Set Union (DSU)** or **Union-Find** data structure is used to efficiently manage disjoint groups and check connectivity among elements.

It supports:
- `find(x)`: Determines the root parent of an element.
- `union(x, y)`: Joins two subsets into a single set.
- `connected(x, y)`: Checks if two elements are in the same subset.

## 🚀 Real-World Use Cases
- Detecting cycles in an undirected graph.
- Network connectivity and clustering (e.g., servers or distributed systems).
- Kruskal’s Minimum Spanning Tree algorithm.
- Social network friend groups.
- Tracking connected components in dynamic graphs.

## ⚙️ Implementation Details
This implementation includes:
- **Path Compression**: Flattens the structure of the tree for fast lookup.
- **Union by Rank**: Balances the tree by attaching smaller trees under larger ones.

## 🧩 Example Output
