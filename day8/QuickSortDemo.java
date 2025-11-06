package day8;

public class QuickSortDemo {

    // Partition method to place pivot correctly
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1;       // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return pivot index
    }

    // Recursive quicksort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // partition index

            quickSort(arr, low, pi - 1);  // sort left side
            quickSort(arr, pi + 1, high); // sort right side
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 3, 8, 2, 7, 1, 4};

        System.out.println("Before Sorting:");
        for (int num : data) System.out.print(num + " ");

        quickSort(data, 0, data.length - 1);

        System.out.println("\nAfter Sorting:");
        for (int num : data) System.out.print(num + " ");
    }
}
