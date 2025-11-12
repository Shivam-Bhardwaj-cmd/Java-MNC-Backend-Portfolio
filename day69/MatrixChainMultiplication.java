package day69;

public class MatrixChainMultiplication {

    // Recursive approach
    public static int matrixChainOrderRecursive(int[] dims, int i, int j) {
        if (i == j) return 0; // Only one matrix, no multiplication

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int count = matrixChainOrderRecursive(dims, i, k)
                      + matrixChainOrderRecursive(dims, k + 1, j)
                      + dims[i - 1] * dims[k] * dims[j];
            min = Math.min(min, count);
        }

        return min;
    }

    // Dynamic Programming approach (Bottom-Up)
    public static int matrixChainOrderDP(int[] dims) {
        int n = dims.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) { // len is chain length
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int count = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    dp[i][j] = Math.min(dp[i][j], count);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] dims = {40, 20, 30, 10, 30};
        System.out.println("Minimum number of multiplications (Recursive): " 
                           + matrixChainOrderRecursive(dims, 1, dims.length - 1));
        System.out.println("Minimum number of multiplications (DP): " 
                           + matrixChainOrderDP(dims));
    }
}
