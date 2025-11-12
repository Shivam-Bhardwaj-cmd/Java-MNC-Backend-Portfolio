package com.dsa.day71;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    // Dynamic Programming approach
    public static int msis(int[] arr) {
        int n = arr.length;
        int[] dp = Arrays.copyOf(arr, n); // dp[i] = max sum ending at i

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int maxSum = 0;
        for (int sum : dp) {
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("Maximum Sum Increasing Subsequence: " + msis(arr));
    }
}
