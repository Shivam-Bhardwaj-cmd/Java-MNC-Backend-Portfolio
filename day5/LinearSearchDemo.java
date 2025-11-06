package com.dsa.day5;

public class LinearSearchDemo {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i; // return index if found
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] data = {15, 8, 23, 4, 42, 16};
        int target = 23;

        int result = linearSearch(data, target);

        if (result != -1)
            System.out.println("✅ Element " + target + " found at index " + result);
        else
            System.out.println("❌ Element not found");
    }
}
