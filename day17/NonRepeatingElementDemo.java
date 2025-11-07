package day17;

import java.util.HashMap;

public class NonRepeatingElementDemo {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 0, 4, 5, 1, 2};

        // Step 1: Build frequency map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find first non-repeating element
        int firstNonRepeating = -1;
        for (int num : arr) {
            if (freqMap.get(num) == 1) {
                firstNonRepeating = num;
                break;
            }
        }

        if (firstNonRepeating != -1)
            System.out.println("First non-repeating element: " + firstNonRepeating);
        else
            System.out.println("No non-repeating element found.");
    }
}
