package day66;

public class LongestCommonSubsequenceOptimized {

    // Function to find LCS length using space-optimized DP
    public static int lcsOptimized(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] prev = new int[n + 1]; // previous row
        int[] curr = new int[n + 1]; // current row

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1]; // characters match
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]); // take max
                }
            }
            // copy current row to previous for next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n]; // final LCS length
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println("Optimized LCS length: " + lcsOptimized(text1, text2));
    }
}
