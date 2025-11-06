package day11;

public class LargestAndSecondLargest {

    public static void findTwoLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array must have at least two elements!");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + (second == Integer.MIN_VALUE ? "None" : second));
    }

    public static void main(String[] args) {
        int[] data = {10, 4, 7, 20, 9, 20};
        findTwoLargest(data);
    }
}
