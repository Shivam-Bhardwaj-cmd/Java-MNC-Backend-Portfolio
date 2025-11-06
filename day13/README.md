echo "# Day 13 – Advanced Prefix Sum Problems (Kadane’s Variants & 2D Prefix)

### 🎯 Objective
Extended prefix sum concepts to handle **circular arrays**, **2D arrays**, and **complex subarray sum** problems.

---

### 🧩 Problems Covered
1. **Maximum Circular Subarray Sum** – Kadane’s variant handling wrap-around arrays.  
2. **Prefix Sum in 2D Matrix** – For fast range-sum queries.  
3. **Subarray Sum Equals K (Using HashMap)** – Optimized O(n) approach using cumulative sums.  

---

### 🧠 Key Learnings
- Kadane’s algorithm can be modified for circular arrays by combining total sum and minimum subarray sum.
- Prefix sums extend naturally to 2D grids for O(1) range queries.
- Using HashMap with cumulative sum improves performance for subarray-sum problems (important for interviews).

---

### 📊 Complexity Overview
| Problem | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Max Circular Subarray Sum | O(n) | O(1) |
| 2D Prefix Sum Query | O(1) (after O(n²) precompute) | O(n²) |
| Subarray Sum Equals K | O(n) | O(n) |

---

### 🧾 Files in This Folder
- MaxCircularSubarray.java  
- PrefixSum2D.java  
- SubarraySumEqualsK.java  
- README.md

" > day13/README.md
