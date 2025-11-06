package day1;

import java.util.Arrays;

public class reverseArrayRecursion {
    public static void reverse(int[] arr, int left, int right) {
        if (left >= right) return; // base case

        // swap
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        // recursive call
        reverse(arr, left + 1, right - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original: " + Arrays.toString(arr));

        reverse(arr, 0, arr.length - 1);
        System.out.println("Reversed: " + Arrays.toString(arr));
    }
}
