package day16;

public class LongestSubarraySumAtMostK {
    public static int longestSubarray(int[] arr, int k) {
        int left = 0, sum = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 7, 1, 10};
        int k = 8;
        System.out.println("Longest subarray with sum ≤ " + k + " = " + longestSubarray(arr, k));
    }
}
