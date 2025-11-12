package day66;

public class LongestCommonSubsequence {

    // Function to find LCS length using standard 2D DP
    public static int lcs(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // DP table, dp[i][j] stores LCS length for text1[0..i-1], text2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // take max
                }
            }
        }

        return dp[m][n]; // final LCS length
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println("LCS length: " + lcs(text1, text2));
    }
}
