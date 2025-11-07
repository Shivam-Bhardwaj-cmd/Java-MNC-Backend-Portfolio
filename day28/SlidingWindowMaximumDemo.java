package day28;

import java.util.*;

public class SlidingWindowMaximumDemo {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Sliding Window Maximum (k=" + k + "):");
        for (int num : result) System.out.print(num + " ");
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            // Remove indices out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();

            // Remove smaller elements (maintain decreasing order)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offerLast(i);

            // Add result after first k elements
            if (i >= k - 1) result[idx++] = nums[dq.peekFirst()];
        }

        return result;
    }
}
