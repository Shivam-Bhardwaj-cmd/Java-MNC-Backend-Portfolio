package day26;

import java.util.*;

public class ReverseQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println("Original Queue: " + queue);
        reverse(queue);
        System.out.println("Reversed Queue: " + queue);
    }

    static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all elements into the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Step 2: Pop all from stack back into queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
