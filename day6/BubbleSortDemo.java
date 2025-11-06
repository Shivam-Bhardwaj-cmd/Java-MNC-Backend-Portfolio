package com.dsa.day6;

public class BubbleSortDemo {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: If no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 1, 4, 2, 8};

        System.out.println("Before Sorting:");
        for (int num : data) System.out.print(num + " ");

        bubbleSort(data);

        System.out.println("\nAfter Sorting:");
        for (int num : data) System.out.print(num + " ");
    }
}
