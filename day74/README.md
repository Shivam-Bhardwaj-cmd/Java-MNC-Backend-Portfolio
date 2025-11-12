# Day 74 - Maximum Sum Increasing Subsequence (MSIS)

## Problem Statement
Given an array of integers, find the sum of the maximum sum increasing subsequence. An increasing subsequence is a sequence of numbers where each number is strictly greater than the previous number.

## Approach
- Use dynamic programming.
- Maintain a dp[] array where dp[i] stores the maximum sum of increasing subsequence ending at index i.
- For each element arr[i], check all previous elements arr[j] (j < i). If arr[i] > arr[j], update dp[i] = max(dp[i], dp[j] + arr[i]).
- Return the maximum value in dp[].

## Code
See `MaximumSumIncreasingSubsequence.java`

## Complexity
- Time Complexity: O(n^2)
- Space Complexity: O(n)
