package day1;

public class fibonaccirecursion {
    public static int fib(int n) {
        // Base case
        if (n <= 1) return n;
        
        // Recursive case
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Fibonacci series up to " + n + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
