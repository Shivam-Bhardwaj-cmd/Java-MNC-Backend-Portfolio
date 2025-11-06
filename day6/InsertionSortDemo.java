package com.dsa.day6;

public class InsertionSortDemo {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;

            // Shift elements greater than current to one position ahead
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the current element in its correct position
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 3, 6, 2, 10};

        System.out.println("Before Sorting:");
        for (int num : data) System.out.print(num + " ");

        insertionSort(data);

        System.out.println("\nAfter Sorting:");
        for (int num : data) System.out.print(num + " ");
    }
}
