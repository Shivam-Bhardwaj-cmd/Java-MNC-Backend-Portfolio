package day17;

import java.util.HashSet;

public class DuplicateDetectionDemo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 20, 50, 10};

        // Step 1: Create a HashSet to track seen elements
        HashSet<Integer> seen = new HashSet<>();

        boolean hasDuplicate = false;

        // Step 2: Traverse array and check duplicates
        for (int num : arr) {
            if (seen.contains(num)) {
                System.out.println("Duplicate found: " + num);
                hasDuplicate = true;
            } else {
                seen.add(num);
            }
        }

        if (!hasDuplicate) {
            System.out.println("No duplicates found.");
        }
    }
}
