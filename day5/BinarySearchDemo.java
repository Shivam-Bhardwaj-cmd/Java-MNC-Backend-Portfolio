package com.dsa.day5;

public class BinarySearchDemo {

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sortedData = {3, 8, 12, 17, 23, 31, 42, 56};
        int target = 31;

        int result = binarySearch(sortedData, target);

        if (result != -1)
            System.out.println("✅ Element " + target + " found at index " + result);
        else
            System.out.println("❌ Element not found");
    }
}
