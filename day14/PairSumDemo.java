package day12;

import java.util.Arrays;

public class PairSumDemo {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15, 5};
        int target = 9;
        System.out.println("Has pair with sum " + target + "? " + hasPairWithSum(arr, target));
    }
}
