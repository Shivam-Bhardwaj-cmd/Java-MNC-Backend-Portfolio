# Day 52 — DSU Applications: Cycle Detection + Kruskal's MST

### 🧠 Concepts Covered
- **Cycle Detection using DSU**
- **Kruskal’s Minimum Spanning Tree using DSU**
- Union-Find structure with path compression & union by rank.

### ⚙️ Cycle Detection Logic
If two nodes belong to the same parent (same set), connecting them will create a **cycle**.

### ⚙️ Kruskal’s MST Logic
1. Sort all edges by weight.
2. Take the smallest edge and check if it forms a cycle.
3. If not, include it in the MST.
4. Continue until we have `V-1` edges.

### 🧩 Time Complexity
- Sorting edges: **O(E log E)**
- DSU Operations: **O(E α(N)) ≈ O(E)**

### 🧠 Example Output
