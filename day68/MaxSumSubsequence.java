package day68;

/**
 * Day 68: Maximum Sum of Increasing Subsequence (DP Variant)
 */
public class MaxSumSubsequence {

    public static int maxSumIncSubseq(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        System.arraycopy(arr, 0, dp, 0, n);

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i])
                    dp[i] = dp[j] + arr[i];

        int max = dp[0];
        for (int val : dp) max = Math.max(max, val);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 10};
        System.out.println("Max sum of increasing subsequence: " + maxSumIncSubseq(arr));
    }
}
