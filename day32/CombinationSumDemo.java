package day32;

import java.util.*;

public class CombinationSumDemo {

    public static void combinationSum(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index == candidates.length) return;

        // Include current number
        current.add(candidates[index]);
        combinationSum(candidates, target - candidates[index], index, current, result);

        // Exclude current number (backtrack)
        current.remove(current.size() - 1);
        combinationSum(candidates, target, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();

        combinationSum(candidates, target, 0, new ArrayList<>(), result);

        System.out.println("Combination sums for target " + target + ":");
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}
