package day24;

import java.util.Stack;

/**
 * Day 24 - Stack Level-3
 * Problem: Largest Rectangle in Histogram
 * Find the area of the largest rectangle in a histogram using a stack.
 */
public class LargestRectangleHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Heights: [2, 1, 5, 6, 2, 3]");
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
