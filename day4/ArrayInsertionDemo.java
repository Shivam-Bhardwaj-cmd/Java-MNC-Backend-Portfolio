package com.dsa.day1;

public class ArrayInsertionDemo {
    public static void main(String[] args) {
        int[] arr = new int[6];
        int n = 5;
        int pos = 2;
        int element = 99;

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        System.out.println("Before insertion:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        for (int i = n; i > pos; i--)
            arr[i] = arr[i - 1];

        arr[pos] = element;
        n++;

        System.out.println("\nAfter insertion:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
