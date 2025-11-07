package day24;

import java.util.*;

/**
 * Day 24 - Stack Level-3
 * Problem: Trapping Rain Water
 * Given n non-negative integers representing elevation map, 
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Elevation map: " + Arrays.toString(height));
        System.out.println("Trapped Water: " + trap(height) + " units");
    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        int trapped = 0;
        for (int i = 0; i < n; i++)
            trapped += Math.min(leftMax[i], rightMax[i]) - height[i];

        return trapped;
    }
}
