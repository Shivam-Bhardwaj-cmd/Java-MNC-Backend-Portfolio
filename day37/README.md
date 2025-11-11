# Day 37: Hashing & Sliding Window Problems

## **Hashing Problems**

### 1. Subarray Sum Equals K
- Count the number of subarrays whose sum equals `k`.
- **Approach:** Prefix sum + HashMap.
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Example:** `[1,2,3,0,3], k=3 → 4 subarrays`

### 2. Two Sum
- Find indices of two numbers that add up to a target.
- **Approach:** HashMap for complement lookup.
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Example:** `[2,7,11,15], target=9 → [0,1]`

### 3. First Non-Repeating Character
- Find the first character in a string that does not repeat.
- **Approach:** HashMap frequency count + iteration.
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)
- **Example:** `"leetcode" → 'l'"`

---

## **Sliding Window Problems**

### 1. Maximum Sum Subarray of Size K
- Find the maximum sum of any subarray of size `k`.
- **Approach:** Fixed-size sliding window.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- **Example:** `[2,1,5,1,3,2], k=3 → 9`

### 2. Longest Substring with At Most K Distinct Characters
- Find the length of the longest substring containing at most `k` distinct characters.
- **Approach:** Variable-length sliding window + HashMap.
- **Time Complexity:** O(n)
- **Space Complexity:** O(k)
- **Example:** `"eceba", k=2 → 3 ("ece")"`

---

## **Files**
- `HashingProblems.java` → All Hashing-related problems
- `SlidingWindowProblems.java` → All Sliding Window problems

---

## **Notes**
- All problems are tested with sample inputs.
- Solutions are efficient and ready for portfolio demonstration.
