# 📘 Day 19 – Stack Fundamentals (Level 1: Core Concepts & Implementations)

## 🚀 Overview
In **Day 19**, we learned the fundamentals of the **Stack** data structure — a linear structure following the **LIFO (Last In, First Out)** principle.  
Stacks are widely used in backend systems, expression parsing, and memory management.

---

## 🧱 What is a Stack?

A **Stack** is a collection of elements with two main operations:
- **push(x)** → Add an element to the top.
- **pop()** → Remove the top element.

### ✳️ Key Operations:
| Operation | Description | Time Complexity |
|------------|--------------|-----------------|
| push(x) | Insert an element | O(1) |
| pop() | Remove top element | O(1) |
| peek() | View top element | O(1) |
| isEmpty() | Check if stack is empty | O(1) |
| size() | Get current stack size | O(1) |

---

## 🧩 1. Stack Using Array – `StackArrayDemo.java`

A static implementation using an integer array.

```java
class StackArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        }
        int value = stackArray[top--];
        System.out.println("Popped: " + value);
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
