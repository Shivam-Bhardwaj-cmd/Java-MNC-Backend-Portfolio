package day26;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedListQueue {
    Node front, rear;

    LinkedListQueue() {
        front = rear = null;
    }

    void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear == null) {
            front = rear = newNode;
            System.out.println(x + " enqueued.");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println(x + " enqueued.");
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow!");
            return;
        }
        System.out.println(front.data + " dequeued.");
        front = front.next;

        if (front == null)
            rear = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedListQueueDemo {
    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.dequeue();
        q.display();

        System.out.println("Front element: " + q.peek());
    }
}
