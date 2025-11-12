package day68;

import java.util.Arrays;

/**
 * Day 68: Maximum Sum Increasing Subsequence (MSIS)
 */
public class MSIS {

    public static int msis(int[] arr) {
        int n = arr.length;
        int[] dp = Arrays.copyOf(arr, n);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int max = dp[0];
        for (int val : dp) max = Math.max(max, val);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("Maximum Sum Increasing Subsequence: " + msis(arr));
    }
}
