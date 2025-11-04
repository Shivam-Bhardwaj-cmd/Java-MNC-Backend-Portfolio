public class TimeComplexityDemo {

    // O(1)
    static void constantTime() {
        System.out.println("Hello World"); // executes once
    }

    // O(n)
    static void linearTime(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // O(n²)
    static void quadraticTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        constantTime();
        linearTime(5);
        quadraticTime(3);
    }
}
