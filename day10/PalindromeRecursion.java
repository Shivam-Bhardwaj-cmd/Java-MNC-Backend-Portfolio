package day10;

public class PalindromeRecursion {

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true; // base case
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "madam";

        if (isPalindrome(input, 0, input.length() - 1))
            System.out.println(input + " is a palindrome.");
        else
            System.out.println(input + " is not a palindrome.");
    }
}
