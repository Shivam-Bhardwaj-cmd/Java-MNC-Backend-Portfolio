package com.dsa.day9;

public class LinearSearchDemo {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i; // Return index when found
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] data = {5, 8, 2, 9, 3, 7};
        int target = 9;

        int result = linearSearch(data, target);

        if (result != -1)
            System.out.println("Element " + target + " found at index " + result);
        else
            System.out.println("Element not found");
    }
}
