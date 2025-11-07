package day32;

import java.util.*;

public class PalindromePartitioningDemo {

    public static void partition(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                partition(s, end + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);

        System.out.println("All palindrome partitions of \"" + s + "\":");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
