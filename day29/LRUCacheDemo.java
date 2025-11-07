package day29;

import java.util.*;

class LRUCache {
    @SuppressWarnings("unused")
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    void put(int key, int value) {
        cache.put(key, value);
    }

    void display() {
        System.out.println("Cache: " + cache);
    }
}

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);
        lru.display();

        lru.get(1); // Access 1 → makes it recently used
        lru.put(4, 40); // Removes key 2 (least recently used)
        lru.display();
    }
}
