# Day 73 - Minimum Jumps to Reach End of Array

## Problem Statement
Given an array of integers `arr[]` where each element represents the maximum number of steps you can jump forward from that element, find the minimum number of jumps to reach the end of the array.

## Approach
- Use a greedy approach to track the **maximum reachable index** at each step.
- Maintain a counter `step` to keep track of remaining steps in the current jump.
- Increment `jumps` when steps run out.
- If current index exceeds `maxReach`, return `-1` (end not reachable).

## Code
See `MinimumJumps.java`

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)
