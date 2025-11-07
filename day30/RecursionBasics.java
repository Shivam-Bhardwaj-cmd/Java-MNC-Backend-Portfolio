package day30;

public class RecursionBasics {

    // Simple recursive function to print numbers 1 to N
    static void printNumbers(int n) {
        if (n == 0) return;
        printNumbers(n - 1);
        System.out.print(n + " ");
    }

    // Factorial using recursion
    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.print("Numbers from 1 to 5: ");
        printNumbers(5);

        System.out.println("\nFactorial of 5: " + factorial(5));
    }
}
