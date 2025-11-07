package day25;

class CircularQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    int count; // keeps track of current number of elements

    CircularQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Add element to the rear
    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }
        rear = (rear + 1) % size;
        arr[rear] = x;
        count++;
        System.out.println(x + " enqueued.");
    }

    // Remove element from the front
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return;
        }
        System.out.println(arr[front] + " dequeued.");
        front = (front + 1) % size;
        count--;
    }

    // Peek element
    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // Check if queue is empty
    boolean isEmpty() {
        return count == 0;
    }

    // Check if queue is full
    boolean isFull() {
        return count == size;
    }

    // Display all elements
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Circular Queue: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[(front + i) % size] + " ");
        }
        System.out.println();
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();

        q.dequeue();
        q.dequeue();
        q.display();

        q.enqueue(60);
        q.enqueue(70);
        q.display();

        System.out.println("Front element: " + q.peek());
    }
}
