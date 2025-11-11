# Day 57 – Floyd-Warshall Algorithm (All-Pairs Shortest Path)

## 🎯 Objective
Implement **Floyd-Warshall Algorithm** to find the shortest paths between **all pairs of vertices** in a weighted directed graph.

---

## 🧩 Key Concepts
- Dynamic Programming approach
- Intermediate vertex relaxation
- Handles **negative edge weights** (but not negative cycles)
- Useful for **network routing**, **API dependency graphs**, and **distributed system latency maps**

---

## ⚙️ Algorithm Steps
1. Initialize a distance matrix with direct edge weights.
2. For each vertex `k`:
   - For each pair `(i, j)`:
     - Update `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`
3. After all iterations, `dist[i][j]` holds the shortest path from `i` to `j`.

---

## 🧮 Time & Space
- **Time Complexity:** O(V³)
- **Space Complexity:** O(V²)

---

## 🧾 Output Example
All-Pairs Shortest Path Matrix (Floyd-Warshall):
0 3 5 6
8 0 2 3
3 6 0 1
2 5 7 0