package day52;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSetKruskal {
    private int[] parent, rank;

    public DisjointSetKruskal(int n) {
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

public class KruskalMSTUsingDSU {
    public static void main(String[] args) {
        int n = 6; // vertices
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 3));
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(2, 3, 4));
        edges.add(new Edge(3, 4, 2));
        edges.add(new Edge(4, 5, 6));

        Collections.sort(edges);

        DisjointSetKruskal ds = new DisjointSetKruskal(n);
        int mstWeight = 0;

        System.out.println("Edges in MST:");
        for (Edge e : edges) {
            if (ds.find(e.src) != ds.find(e.dest)) {
                ds.union(e.src, e.dest);
                mstWeight += e.weight;
                System.out.println(e.src + " - " + e.dest + " (weight " + e.weight + ")");
            }
        }

        System.out.println("Total MST Weight: " + mstWeight);
    }
}
