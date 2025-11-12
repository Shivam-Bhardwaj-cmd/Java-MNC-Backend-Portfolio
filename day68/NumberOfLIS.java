package day68;

import java.util.Arrays;

/**
 * Day 68: Number of Longest Increasing Subsequences
 */
public class NumberOfLIS {

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lengths = new int[n]; // length of LIS ending at i
        int[] counts = new int[n];  // number of LIS ending at i
        Arrays.fill(counts, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }

        int longest = 0, total = 0;
        for (int len : lengths) longest = Math.max(longest, len);
        for (int i = 0; i < n; i++) if (lengths[i] == longest) total += counts[i];
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println("Number of Longest Increasing Subsequences: " + findNumberOfLIS(nums));
    }
}
