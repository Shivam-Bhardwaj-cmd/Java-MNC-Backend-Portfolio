package day28;

import java.util.Stack;

public class MonotonicStackDemo {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int[] result = nextGreaterUsingMonotonicStack(nums);

        System.out.println("Next Greater using Monotonic Stack:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " → " + result[i]);
        }
    }

    static int[] nextGreaterUsingMonotonicStack(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }
}
