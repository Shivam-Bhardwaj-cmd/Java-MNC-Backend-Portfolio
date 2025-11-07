package day26;

import java.util.*;

public class GenerateBinaryNumbersDemo {
    public static void main(String[] args) {
        int n = 10;
        generateBinary(n);
    }

    static void generateBinary(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        System.out.println("First " + n + " binary numbers:");

        for (int i = 1; i <= n; i++) {
            String front = queue.remove();
            System.out.print(front + " ");
            queue.add(front + "0");
            queue.add(front + "1");
        }
    }
}
