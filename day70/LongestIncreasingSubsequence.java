package day70;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // Dynamic Programming (O(n^2))
    public static int lisDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int length : dp) {
            max = Math.max(max, length);
        }
        return max;
    }

    // Efficient approach using binary search (O(n log n))
    public static int lisBinarySearch(int[] arr) {
        int[] sub = new int[arr.length];
        int length = 0;

        for (int x : arr) {
            int i = Arrays.binarySearch(sub, 0, length, x);
            if (i < 0) i = -(i + 1);
            sub[i] = x;
            if (i == length) length++;
        }

        return length;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS length (DP): " + lisDP(arr));
        System.out.println("LIS length (Binary Search): " + lisBinarySearch(arr));
    }
}
