package com.dsa.day65;

public class EditDistanceOptimized {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // Base case: converting empty word1 to word2
        for (int j = 0; j <= n; j++) prev[j] = j;

        for (int i = 1; i <= m; i++) {
            curr[0] = i; // converting first i chars of word1 to empty word2
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1]; // same char, no operation
                } else {
                    curr[j] = 1 + Math.min(
                            prev[j - 1], // replace
                            Math.min(prev[j], // delete
                                     curr[j - 1]) // insert
                    );
                }
            }
            // Move current row to previous for next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    public static void main(String[] args) {
        String word1 = "kitten";
        String word2 = "sitting";

        int distance = minDistance(word1, word2);
        System.out.println("Minimum edit distance (optimized): " + distance);
    }
}
