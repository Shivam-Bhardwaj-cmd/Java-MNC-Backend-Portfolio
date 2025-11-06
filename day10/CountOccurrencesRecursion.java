package day10;

public class CountOccurrencesRecursion {

    public static int countOccurrences(int[] arr, int n, int target) {
        if (n < 0) return 0;
        return (arr[n] == target ? 1 : 0) + countOccurrences(arr, n - 1, target);
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 2, 4, 2, 5};
        int target = 2;

        int count = countOccurrences(data, data.length - 1, target);
        System.out.println("Element " + target + " occurs " + count + " times.");
    }
}
