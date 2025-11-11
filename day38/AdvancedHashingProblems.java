package com.dsa.day38;

import java.util.*;

public class AdvancedHashingProblems {

    // 1. Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) { // start of a sequence
                int current = num;
                int streak = 1;

                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }

    // 2. Subarray with 0 sum exists?
    public static boolean subarrayWithZeroSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum == 0 || set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }

    // 3. Count distinct elements in every window of size k
    public static List<Integer> countDistinctInWindow(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i >= k - 1) {
                result.add(map.size());
                int start = nums[i - k + 1];
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) map.remove(start);
            }
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive: " + longestConsecutive(nums1));

        int[] nums2 = {4, 2, -3, 1, 6};
        System.out.println("Subarray with zero sum exists? " + subarrayWithZeroSum(nums2));

        int[] nums3 = {1, 2, 1, 3, 4, 2, 3};
        System.out.println("Distinct in every window of size 4: " + countDistinctInWindow(nums3, 4));
    }
}
