package day32;

import java.util.*;

public class SubsetsWithDupDemo {

    public static void subsetsWithDup(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue; // skip duplicates
            current.add(nums[i]);
            subsetsWithDup(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        subsetsWithDup(nums, 0, new ArrayList<>(), result);

        System.out.println("All subsets (no duplicates):");
        for (List<Integer> subset : result)
            System.out.println(subset);
    }
}
