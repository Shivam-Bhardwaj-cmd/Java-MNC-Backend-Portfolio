package day63;

public class LongestCommonSubstring {

    public static int longestCommonSubstring(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String X = "abcde";
        String Y = "abfce";
        System.out.println("Longest Common Substring length: " + longestCommonSubstring(X, Y));
    }
}
