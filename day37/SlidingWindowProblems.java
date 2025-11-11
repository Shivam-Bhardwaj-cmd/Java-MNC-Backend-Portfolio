package day37;

import java.util.*;

public class SlidingWindowProblems {

    // Problem 1: Maximum Sum Subarray of Size K
    public static int maxSumSubarrayOfSizeK(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[i - k + 1];
            }
        }
        return maxSum;
    }

    // Problem 2: Longest Substring with At Most K Distinct Characters
    public static int longestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Maximum Sum Subarray of Size K
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max Sum Subarray of Size K: " + maxSumSubarrayOfSizeK(arr, k)); // 9

        // Longest Substring with At Most K Distinct Characters
        String s = "eceba";
        int kDistinct = 2;
        System.out.println("Longest Substring with At Most K Distinct: " + longestSubstringKDistinct(s, kDistinct)); // 3
    }
}
