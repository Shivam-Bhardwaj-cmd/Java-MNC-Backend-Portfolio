package day46;

import java.util.*;

@SuppressWarnings("unused")
class DisjointSet {
    private int[] parent;
    private int[] rank;

    // Constructor to initialize n disjoint sets
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;  // each node is its own parent initially
            rank[i] = 0;    // rank (approximate tree height)
        }
    }

    // Find operation with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // path compression
        }
        return parent[x];
    }

    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return; // already in same set

        // attach smaller tree under root of larger tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // Check if two nodes are connected
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

public class DisjointSetDemo {
    public static void main(String[] args) {
        int n = 7;
        DisjointSet ds = new DisjointSet(n);

        // Connect some elements
        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);
        ds.union(5, 6);

        System.out.println("Are 0 and 2 connected? " + ds.connected(0, 2)); // ✅ true
        System.out.println("Are 3 and 5 connected? " + ds.connected(3, 5)); // ❌ false

        ds.union(4, 5);
        System.out.println("After union(4,5): Are 3 and 6 connected? " + ds.connected(3, 6)); // ✅ true

        // Display all parent relationships
        System.out.println("\nFinal parent array:");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + ds.find(i));
        }
    }
}
