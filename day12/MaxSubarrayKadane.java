package day12;

public class MaxSubarrayKadane {

    public static int kadaneMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        System.out.println("Maximum Subarray Sum: " + kadaneMaxSum(arr));
    }
}
