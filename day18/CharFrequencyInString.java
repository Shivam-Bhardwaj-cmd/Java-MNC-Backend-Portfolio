package day18;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CharFrequencyInString {
    public static void main(String[] args) {
        String str = "success";
        System.out.println("Character Frequency in \"" + str + "\":");
        countCharFrequency(str);
    }

    public static void countCharFrequency(String str) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Sort alphabetically (optional, for neat output)
        TreeMap<Character, Integer> sortedMap = new TreeMap<>(freqMap);

        // Step 3: Display
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
