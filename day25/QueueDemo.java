package day25;

class Queue {
    int[] arr;
    int front;
    int rear;
    int size;

    Queue(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }

    // Add element to the rear
    void enqueue(int x) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow!");
            return;
        }
        if (front == -1) front = 0; // first insertion
        arr[++rear] = x;
        System.out.println(x + " enqueued.");
    }

    // Remove element from the front
    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow!");
            return;
        }
        System.out.println(arr[front] + " dequeued.");
        front++;
    }

    // Peek element
    int peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // Display the queue
    void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.display();

        System.out.println("Front element: " + q.peek());
        q.dequeue();
        q.display();

        q.enqueue(50);
        q.enqueue(60); // Will overflow here
    }
}
