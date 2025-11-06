package day15;

public class CountSubarraysWithAverage {
    public static int countSubarraysWithAverage(int[] arr, int k, double targetAvg) {
        int count = 0;
        double targetSum = targetAvg * k;
        double currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        if (currentSum == targetSum) count++;

        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            if (currentSum == targetSum) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5, 2, 3};
        int k = 3;
        double targetAvg = 3.0;
        System.out.println("Count of subarrays with average " + targetAvg + " = " +
                countSubarraysWithAverage(arr, k, targetAvg));
    }
}
