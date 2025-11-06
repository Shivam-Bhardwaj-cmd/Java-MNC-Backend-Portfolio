package com.dsa.day9;

public class BinarySearchDemo {

    // Iterative Binary Search
    public static int binarySearchIterative(int[] arr, int target) {
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

    // Recursive Binary Search
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                return binarySearchRecursive(arr, mid + 1, right, target);
            else
                return binarySearchRecursive(arr, left, mid - 1, target);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 5, 7, 9, 11, 15};
        int target = 9;

        int iterativeResult = binarySearchIterative(data, target);
        int recursiveResult = binarySearchRecursive(data, 0, data.length - 1, target);

        System.out.println("Iterative Binary Search: Element " + target +
                (iterativeResult != -1 ? " found at index " + iterativeResult : " not found"));

        System.out.println("Recursive Binary Search: Element " + target +
                (recursiveResult != -1 ? " found at index " + recursiveResult : " not found"));
    }
}
