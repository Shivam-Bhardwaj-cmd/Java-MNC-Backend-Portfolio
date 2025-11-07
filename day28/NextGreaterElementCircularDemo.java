package day28;

import java.util.Stack;

public class NextGreaterElementCircularDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterCircular(nums);

        System.out.println("Next Greater in Circular Array:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " → " + result[i]);
        }
    }

    static int[] nextGreaterCircular(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }

        return result;
    }
}
