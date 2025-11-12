package day75;

public class Day75Portfolio {

    // 1. Maximum Product Subarray
    public static int maxProductSubarray(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxProd;
            maxProd = Math.max(Math.max(nums[i], maxProd * nums[i]), minProd * nums[i]);
            minProd = Math.min(Math.min(nums[i], temp * nums[i]), minProd * nums[i]);
            result = Math.max(result, maxProd);
        }
        return result;
    }

    // 2. Minimum Jumps to Reach End
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    // 3. Longest Palindromic Subsequence
    public static int longestPalindromicSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + maxProductSubarray(nums));

        int[] jumps = {2, 3, 1, 1, 4};
        System.out.println("Minimum Jumps to Reach End: " + minJumps(jumps));

        String str = "agbdba";
        System.out.println("Longest Palindromic Subsequence: " + longestPalindromicSubseq(str));
    }
}
