package day74;

public class MaximumSumIncreasingSubsequence {

    // Function to find maximum sum increasing subsequence
    public static int maxSumIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        // Initialize dp[] with array values
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        // Build the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        // Find maximum in dp[]
        int maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("Maximum Sum Increasing Subsequence: " + maxSumIS(arr));
    }
}
