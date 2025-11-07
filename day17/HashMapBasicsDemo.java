package day17;

import java.util.HashMap;

public class HashMapBasicsDemo {
    public static void main(String[] args) {
        // Create a HashMap to store country and their population
        HashMap<String, Integer> map = new HashMap<>();

        // 1. Insert key-value pairs
        map.put("India", 140);
        map.put("USA", 33);
        map.put("China", 145);
        map.put("UK", 7);

        // 2. Display map
        System.out.println("Country Map: " + map);

        // 3. Access value by key
        System.out.println("Population of India: " + map.get("India"));

        // 4. Check if key exists
        System.out.println("Contains key 'Japan'? " + map.containsKey("Japan"));

        // 5. Remove a key
        map.remove("UK");
        System.out.println("After removing UK: " + map);

        // 6. Iterate through the HashMap
        System.out.println("\nIterating over entries:");
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key) + " crore");
        }

        // 7. Size of HashMap
        System.out.println("\nTotal entries: " + map.size());
    }
}
