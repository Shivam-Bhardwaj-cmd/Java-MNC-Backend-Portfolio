package com.dsa.day1;

public class ArrayDeletionDemo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;
        int pos = 2; // delete element at index 2

        System.out.println("Before deletion:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        for (int i = pos; i < n - 1; i++)
            arr[i] = arr[i + 1];
        n--;

        System.out.println("\nAfter deletion:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
