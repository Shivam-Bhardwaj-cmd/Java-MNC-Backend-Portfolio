package day18;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"bat", "tab", "cat", "tac", "act", "dog"};
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : words) {
            // Sort characters of each word to create a key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add word to corresponding key list
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(word);
        }

        // Print groups of anagrams
        System.out.println("Grouped Anagrams:");
        for (List<String> group : anagramMap.values()) {
            System.out.println(group);
        }
    }
}
