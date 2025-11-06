package com.dsa.day4;

public class ArrayStatsDemo {

    // Method to calculate and display statistics
    public static void analyzeArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty!");
            return;
        }

        int sum = 0;
        int max = arr[0];
        int min = arr[0];
        int evenCount = 0;
        int oddCount = 0;

        // Traverse through array once
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            sum += num;

            if (num > max) max = num;
            if (num < min) min = num;

            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }

        double average = (double) sum / arr.length;

        System.out.println("📊 Array Statistics Report:");
        System.out.println("----------------------------");
        System.out.println("Array elements: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n----------------------------");
        System.out.println("Total Elements: " + arr.length);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Even Count: " + evenCount);
        System.out.println("Odd Count: " + oddCount);
    }

    public static void main(String[] args) {
        int[] sampleArray = {12, 7, 9, 20, 33, 14, 8};

        System.out.println("Running ArrayStatsDemo...");
        analyzeArray(sampleArray);
    }
}
