# 🧩 Day 34 — Recursion Applications (Backtracking + Real Use Cases)

## 📘 Overview

**Objective:**  
Understand how recursion and backtracking power real-world problem solving — from pathfinding and optimization to constraint satisfaction.  
These concepts form the base for **system design algorithms** like route optimization, scheduling, and intelligent search.

---

## 🔍 Topics Covered

| Concept | Description |
|----------|--------------|
| **Backtracking** | A recursion-based method for exploring all possible solutions by making and undoing choices. |
| **Pathfinding (Maze Problem)** | Finding all valid routes through a grid using recursion. |
| **N-Queens Problem** | Classic constraint satisfaction example using recursion + backtracking. |

---

## ⚙️ 1️⃣ MazePathFinder.java

### 📄 Code
```java
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePathFinder {

    public static void main(String[] args) {
        int n = 3, m = 3;
        List<String> allPaths = findPaths("", n, m);
        System.out.println("All possible paths from start to end:");
        for (String path : allPaths) {
            System.out.println(path);
        }
    }

    static List<String> findPaths(String path, int row, int col) {
        List<String> paths = new ArrayList<>();

        if (row == 1 && col == 1) {
            paths.add(path);
            return paths;
        }

        // Move Down
        if (row > 1) {
            paths.addAll(findPaths(path + "D", row - 1, col));
        }

        // Move Right
        if (col > 1) {
            paths.addAll(findPaths(path + "R", row, col - 1));
        }

        return paths;
    }
}
