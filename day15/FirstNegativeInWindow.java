package day15;

import java.util.*;

public class FirstNegativeInWindow {
    public static void printFirstNegative(int[] arr, int k) {
        Queue<Integer> negatives = new LinkedList<>();

        // Process first window
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) negatives.add(i);
        }

        for (int i = k; i <= arr.length; i++) {
            // Print result for current window
            if (negatives.isEmpty()) {
                System.out.print("0 ");
            } else {
                System.out.print(arr[negatives.peek()] + " ");
            }

            // Slide window
            if (i < arr.length) {
                if (!negatives.isEmpty() && negatives.peek() <= i - k) negatives.poll();
                if (arr[i] < 0) negatives.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.print("First negatives in every window of size " + k + ": ");
        printFirstNegative(arr, k);
    }
}
