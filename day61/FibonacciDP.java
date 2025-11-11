package day61;

import java.util.*;

public class FibonacciDP {

    // Recursive + Memoization (Top-Down)
    public static int fibMemo(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
        return dp[n];
    }

    // Tabulation (Bottom-Up)
    public static int fibTab(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Fibonacci (Memoization): " + fibMemo(n, dp));
        System.out.println("Fibonacci (Tabulation): " + fibTab(n));
    }
}
