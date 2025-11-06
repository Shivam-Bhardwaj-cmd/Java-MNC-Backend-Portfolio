package day12;

public class SubarrayWithGivenSum {

    public static boolean hasSubarraySum(int[] arr, int target) {
        int start = 0, sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > target && start <= end) {
                sum -= arr[start++];
            }

            if (sum == target) {
                System.out.println("Subarray found between indexes " + start + " and " + end);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int target = 33;

        if (!hasSubarraySum(arr, target))
            System.out.println("No subarray with given sum found.");
    }
}
