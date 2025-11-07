package day30;

import java.util.*;

public class PermutationsBacktracking {
    public static void generatePermutations(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            generatePermutations(nums, used, current, result);

            // Un-choose (Backtrack)
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();

        generatePermutations(nums, new boolean[nums.length], new ArrayList<>(), result);

        System.out.println("All Permutations:");
        for (List<Integer> permutation : result)
            System.out.println(permutation);
    }
}
