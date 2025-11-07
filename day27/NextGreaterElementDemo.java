package day27;

import java.util.Stack;

public class NextGreaterElementDemo {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 7, 8};
        printNextGreaterElements(arr);
    }

    static void printNextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        System.out.println("Element → Next Greater Element");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " → " + result[i]);
        }
    }
}
