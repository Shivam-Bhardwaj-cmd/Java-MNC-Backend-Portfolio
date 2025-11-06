package day10;

public class ReverseStringRecursion {

    public static String reverse(String str) {
        if (str.isEmpty()) return str; // base case
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String input = "Shivam";
        String reversed = reverse(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
