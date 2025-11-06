package com.dsa.day11;

public class FindMissingNumber {

    public static int findMissing(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) actualSum += num;

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 4, 5, 6};
        int n = 6;
        System.out.println("Missing number: " + findMissing(data, n));
    }
}
