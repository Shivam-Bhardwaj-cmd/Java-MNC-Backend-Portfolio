package day51;

import java.util.*;

@SuppressWarnings("unused")
public class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each node is initially its own parent
            rank[i] = 0;
        }
    }

    // Find with path compression
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    // Union by rank
    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return; // Already in same set

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }

    public void printParents() {
        System.out.print("Parent Array: ");
        for (int i = 0; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
