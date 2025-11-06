package day2;

public class SpaceComplexityDemo {

    // O(1) space - no extra data structures
    static void constantSpace(int n) {
        int count = 0;  // single variable
        for (int i = 0; i < n; i++) {
            count++;
        }
        System.out.println("Constant Space O(1) Example: " + count);
    }

    // O(n) space - uses an array proportional to input size
    static void linearSpace(int n) {
        int[] arr = new int[n];  // extra space of n
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        System.out.println("Linear Space O(n) Example: " + arr[n - 1]);
    }

    // Combined time & space complexity understanding
    public static void main(String[] args) {
        constantSpace(5);
        linearSpace(10);
    }
}
