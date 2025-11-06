package day10;

public class SumofArrayRecursion {

    public static int findSum(int[] arr, int n) {
        // Base case: single element
        if (n == 0) return arr[0];

        // Recursive case
        return arr[n] + findSum(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 3};
        int result = findSum(data, data.length - 1);

        System.out.println("Sum of array elements: " + result);
    }
}
