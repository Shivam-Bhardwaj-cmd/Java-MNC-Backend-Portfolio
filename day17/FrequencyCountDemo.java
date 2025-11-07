package day17;

import java.util.HashMap;

public class FrequencyCountDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 4, 1, 5, 2, 2, 3, 1};

        // Create a HashMap to store frequency of each number
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Display frequency of each element
        System.out.println("Element Frequencies:");
        for (int key : freqMap.keySet()) {
            System.out.println(key + " -> " + freqMap.get(key));
        }

        // Example: Find element with maximum frequency
        int maxFreq = 0;
        int maxElement = -1;
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) > maxFreq) {
                maxFreq = freqMap.get(key);
                maxElement = key;
            }
        }

        System.out.println("\nElement with max frequency: " + maxElement + " (appears " + maxFreq + " times)");
    }
}
