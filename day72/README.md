# Day 72 - Longest Bitonic Subsequence (LBS)

**Topic:** Dynamic Programming

**Description:**
Longest Bitonic Subsequence (LBS) is a sequence which is first strictly increasing then strictly decreasing. The problem is to find the length of the longest bitonic subsequence in an array.

**Implemented Approach:**
- Dynamic Programming (O(n^2) time, O(n) space)
- Compute LIS (Longest Increasing Subsequence)
- Compute LDS (Longest Decreasing Subsequence)
- Combine to get LBS

**Key Concepts:**
- Dynamic Programming
- Increasing and Decreasing Subsequences
- Optimal Substructure

**Time Complexity:** O(n^2)  
**Space Complexity:** O(n)
