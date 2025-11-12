package day67;

public class EditDistanceRecursive {
    
    public static int editDistance(String s1, String s2, int m, int n) {
        if (m == 0) return n; // Insert all remaining characters of s2
        if (n == 0) return m; // Remove all remaining characters of s1

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDistance(s1, s2, m - 1, n - 1);
        }

        return 1 + Math.min(
                editDistance(s1, s2, m, n - 1),    // Insert
                Math.min(
                        editDistance(s1, s2, m - 1, n), // Remove
                        editDistance(s1, s2, m - 1, n - 1) // Replace
                )
        );
    }

    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";
        System.out.println("Edit Distance: " + editDistance(str1, str2, str1.length(), str2.length()));
    }
}
