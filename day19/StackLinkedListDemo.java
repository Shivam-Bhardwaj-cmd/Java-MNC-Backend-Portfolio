package day19;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class StackLinkedList {
    private Node top;

    public StackLinkedList() {
        top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int value = top.data;
        top = top.next;
        System.out.println("Popped: " + value);
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class StackLinkedListDemo {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(100);
        stack.push(200);
        stack.push(300);
        System.out.println("Top element: " + stack.peek());
        stack.pop();
        stack.pop();
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
