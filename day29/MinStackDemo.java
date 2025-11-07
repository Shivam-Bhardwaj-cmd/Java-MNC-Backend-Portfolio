package day29;

import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        System.out.println(x + " pushed.");
    }

    void pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack Underflow!");
            return;
        }
        int removed = mainStack.pop();
        if (removed == minStack.peek()) minStack.pop();
        System.out.println(removed + " popped.");
    }

    int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack empty!");
            return -1;
        }
        return minStack.peek();
    }
}

public class MinStackDemo {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        System.out.println("Min: " + s.getMin());
        s.push(2);
        s.push(1);
        System.out.println("Min: " + s.getMin());
        s.pop();
        System.out.println("Min: " + s.getMin());
    }
}
