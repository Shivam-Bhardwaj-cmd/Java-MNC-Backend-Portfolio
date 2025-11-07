# 📘 Day 21 – Stack Level 3 (Next Greater Element & Stock Span Problem)

In this module, we dive into **real interview-grade Stack problems** that demonstrate how stacks can efficiently solve traversal and comparison-based array problems in **O(n)** time.
These are frequently asked in MNC technical rounds and are also used in backend systems for stock analytics, monitoring, and trend detection.

---

## 🎯 Learning Goals

* Understand the **Next Greater Element (NGE)** pattern using Stack.
* Implement the **Stock Span Problem** efficiently using Stack.
* Master how to optimize nested loops using a monotonic stack.

---

## 🧩 Program 1: Next Greater Element (NGE)

**File:** `NextGreaterElementDemo.java`

### Problem

For each element in the array, find the **next greater element** on its right.
If no greater element exists, output `-1`.

### Example

```
Input:  [4, 5, 2, 25]
Output: [5, 25, 25, -1]
```

### Key Idea

* Traverse from **right to left**.
* Maintain a Stack to store potential "next greater" values.
* Pop smaller or equal elements until a greater one is found.
* Push the current element for use by the next iteration.

### Output

```
Next Greater Elements: 5 25 25 -1
```

### Complexity

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(n)       |
| Space | O(n)       |

---

## 🧩 Program 2: Stock Span Problem

**File:** `StockSpanProblemDemo.java`

### Problem

For each day’s stock price, calculate how many consecutive days before (including current day) the price was **less than or equal** to today’s price.

### Example

```
Input:  [100, 80, 60, 70, 60, 75, 85]
Output: [1, 1, 1, 2, 1, 4, 6]
```

### Key Idea

* Use a stack of pairs `(price, span)`.
* For each new price:

  * Pop all smaller or equal prices.
  * Add their spans to the current span.
* Push the current price with its final span.

### Output

```
Stock Span: 1 1 1 2 1 4 6
```

### Complexity

| Type  | Complexity |
| ----- | ---------- |
| Time  | O(n)       |
| Space | O(n)       |

---

## 💼 Real-World Applications

| Use Case                          | Description                                            |
| --------------------------------- | ------------------------------------------------------ |
| **Stock Analysis Systems**        | Used for price trend evaluation and duration tracking. |
| **Backend Monitoring Dashboards** | Detects duration of stable/peak performance metrics.   |
| **Compiler Optimization**         | Used in dependency and dominance analysis.             |
| **Algorithmic Trading Engines**   | Predicts duration of upward/downward stock trends.     |

---

## 🗂 Folder Structure

```
day21/
 ├── NextGreaterElementDemo.java
 ├── StockSpanProblemDemo.java
 └── README.md
```

---

✅ **End of Day 21** – You’ve mastered two of the most important stack-based patterns for efficient traversal and array analytics.
