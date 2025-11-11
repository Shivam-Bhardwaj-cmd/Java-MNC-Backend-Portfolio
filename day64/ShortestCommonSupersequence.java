package day64;

public class ShortestCommonSupersequence {

    public static int lcs(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    public static int shortestCommonSupersequence(String X, String Y) {
        int lcsLen = lcs(X, Y);
        return X.length() + Y.length() - lcsLen;
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of Shortest Common Supersequence: " + shortestCommonSupersequence(X, Y));
    }
}
