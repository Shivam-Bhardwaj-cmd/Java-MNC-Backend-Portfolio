package day68;

/**
 * Day 68: Longest Increasing Subsequence (Recursive)
 */
public class LISRecursive {

    public static int lis(int[] arr, int n) {
        if (n == 1) return 1;

        int maxEndingHere = 1;

        for (int i = 1; i < n; i++) {
            int res = lis(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > maxEndingHere) {
                maxEndingHere = res + 1;
            }
        }
        return maxEndingHere;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        int max = 1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, lis(arr, i));
        }
        System.out.println("Length of LIS (Recursive): " + max);
    }
}
