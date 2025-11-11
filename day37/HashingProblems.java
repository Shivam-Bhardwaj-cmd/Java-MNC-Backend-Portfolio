package day37;

import java.util.*;

public class HashingProblems {

    // Problem 1: Subarray Sum Equals K
    public static int subarraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            count += prefixSumMap.getOrDefault(sum - k, 0);
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // Problem 2: Two Sum
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // No solution
    }

    // Problem 3: First Non-Repeating Character
    public static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return '\0'; // Return null char if not found
    }

    // Main method for testing
    public static void main(String[] args) {
        // Subarray Sum Equals K
        int[] arr1 = {1, 2, 3, 0, 3};
        int k = 3;
        System.out.println("Subarray Sum Equals K: " + subarraySumEqualsK(arr1, k)); // 4

        // Two Sum
        int[] arr2 = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Two Sum indices: " + Arrays.toString(twoSum(arr2, target))); // [0, 1]

        // First Non-Repeating Character
        String s = "leetcode";
        System.out.println("First Non-Repeating Character: " + firstNonRepeatingChar(s)); // l
    }
}
