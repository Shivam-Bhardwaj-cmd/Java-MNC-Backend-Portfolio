package day11;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void moveZeros(int[] arr) {
        int index = 0; // position for non-zero

        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }

        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] data = {0, 1, 0, 3, 12};
        moveZeros(data);
        System.out.println("After moving zeros: " + Arrays.toString(data));
    }
}
