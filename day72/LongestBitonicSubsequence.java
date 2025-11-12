package day72;

import java.util.Arrays;

public class LongestBitonicSubsequence {

    public static int lbs(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n]; // Longest Increasing Subsequence ending at i
        int[] lds = new int[n]; // Longest Decreasing Subsequence starting at i

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        // Compute LIS
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Compute LDS
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        // Find max LBS
        int maxLBS = 0;
        for (int i = 0; i < n; i++) {
            maxLBS = Math.max(maxLBS, lis[i] + lds[i] - 1);
        }

        return maxLBS;
    }

    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println("Length of Longest Bitonic Subsequence: " + lbs(arr));
    }
}
