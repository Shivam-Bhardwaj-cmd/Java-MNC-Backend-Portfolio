# Day 40: Advanced Graph Algorithms

This day focuses on advanced graph algorithms commonly asked in MNC interviews and used in competitive programming:

## **Topics Covered**

1. **Dijkstra’s Algorithm**
   - Find shortest paths from a source vertex to all other vertices in a weighted graph.
   - Implemented in `DijkstraDemo.java`.

2. **Minimum Spanning Tree (Prim’s Algorithm)**
   - Generate a minimum spanning tree of a weighted undirected graph.
   - Implemented in `MSTDemo.java`.

3. **Topological Sorting**
   - Linear ordering of vertices in a Directed Acyclic Graph (DAG).
   - Implemented in `TopologicalSortDemo.java`.

4. **Cycle Detection in Graphs**
   - Detect cycles in a directed graph using DFS.
   - Implemented in `DetectCycleGraph.java`.

## **Folder Structure**
DijkstraDemo.java
│ TopologicalSortDemo.java
│ DetectCycleGraph.java
│ MSTDemo.java
│ README.md

## **How to Run**

1. Clone the repository or copy the `day40` folder.
2. Compile the Java files:
   ```bash
   javac *.java
java DijkstraDemo
java MSTDemo
java TopologicalSortDemo
java DetectCycleGraph
Key Notes

GraphBasics.java is used as a common utility class for weighted graphs.

Topological sorting and cycle detection use adjacency lists for DAGs.

These implementations are interview-ready and suitable for MNC coding rounds.