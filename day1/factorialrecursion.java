package day1;

public class factorialrecursion {
    public static int factorial(int n) {
        // Base case: stop when n == 0
        if (n == 0) return 1;
        
        // Recursive case: n * factorial of (n-1)
        int result = n * factorial(n - 1);
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }
}
