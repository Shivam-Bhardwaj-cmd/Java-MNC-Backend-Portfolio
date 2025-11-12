package day73;

public class MinimumJumps {

    // Function to find minimum jumps to reach end
    public static int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 0 || arr[0] == 0) {
            return -1; // Cannot move anywhere
        }

        int jumps = 0;      // Number of jumps made
        int maxReach = 0;   // Maximum index we can reach so far
        int step = 0;       // Steps we can still take

        for (int i = 0; i < n - 1; i++) {
            // Update the maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // Use a step to move to next index
            step--;

            // If no more steps remain, we need to jump
            if (step == 0) {
                jumps++;
                // If current index is greater than maxReach, we can't move forward
                if (i >= maxReach) {
                    return -1;
                }
                // Re-initialize steps for the new jump
                step = maxReach - i;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps to reach end: " + minJumps(arr));
    }
}
