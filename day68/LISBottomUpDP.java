package day68;

import java.util.Arrays;

/**
 * Day 68: Longest Increasing Subsequence (Bottom-Up DP)
 */
public class LISBottomUpDP {

    public static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 1;
        for (int val : dp) max = Math.max(max, val);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of LIS: " + lis(arr));
    }
}
