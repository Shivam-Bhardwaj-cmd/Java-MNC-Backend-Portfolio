package com.dsa.day12;

public class SubarraySumBruteForce {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};

        System.out.println("All Subarray Sums:");
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += arr[k];
                }
                System.out.println("Sum of subarray (" + start + "," + end + ") = " + sum);
            }
        }
    }
}
