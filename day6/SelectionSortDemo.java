package com.dsa.day6;

public class SelectionSortDemo {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 3, 6, 2, 10};

        System.out.println("Before Sorting:");
        for (int num : data) System.out.print(num + " ");

        selectionSort(data);

        System.out.println("\nAfter Sorting:");
        for (int num : data) System.out.print(num + " ");
    }
}
