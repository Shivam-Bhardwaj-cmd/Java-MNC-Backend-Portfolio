package day27;

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int x) {
        s1.push(x);
        System.out.println(x + " enqueued.");
    }

    int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return s2.pop();
    }

    void display() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Queue elements (front → rear): ");
        for (int i = s2.size() - 1; i >= 0; i--) System.out.print(s2.get(i) + " ");
        for (int i = 0; i < s1.size(); i++) System.out.print(s1.get(i) + " ");
        System.out.println();
    }
}

public class QueueUsingTwoStacksDemo {
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println(q.dequeue() + " dequeued.");
        q.display();
    }
}
