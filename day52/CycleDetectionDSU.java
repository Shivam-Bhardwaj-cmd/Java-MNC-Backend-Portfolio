package day52;

import java.util.*;

class DisjointSet {
    private int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if (parent[node] != node)
            parent[node] = find(parent[node]);
        return parent[node];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) return;

        if (rank[rootU] < rank[rootV]) parent[rootU] = rootV;
        else if (rank[rootU] > rank[rootV]) parent[rootV] = rootU;
        else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}

public class CycleDetectionDSU {
    static class Edge {
        int src, dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static boolean hasCycle(int n, List<Edge> edges) {
        DisjointSet ds = new DisjointSet(n);

        for (Edge edge : edges) {
            int rootU = ds.find(edge.src);
            int rootV = ds.find(edge.dest);

            if (rootU == rootV)
                return true; // Cycle detected
            ds.union(edge.src, edge.dest);
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1));
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(4, 1)); // Cycle

        System.out.println("Cycle present: " + hasCycle(n, edges));
    }
}
