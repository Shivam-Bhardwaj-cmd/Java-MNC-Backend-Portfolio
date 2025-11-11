package day47;

import java.util.*;

class Edge {
    int src, dest;
    Edge(int s, int d) {
        src = s;
        dest = d;
    }
}

class DisjointSet {
    private int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

public class CycleDetectionUnionFind {
    public static boolean hasCycle(int V, List<Edge> edges) {
        DisjointSet ds = new DisjointSet(V);

        for (Edge e : edges) {
            int root1 = ds.find(e.src);
            int root2 = ds.find(e.dest);

            if (root1 == root2) return true; // cycle detected
            ds.union(root1, root2);
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1));
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(1, 4)); // This will create a cycle

        System.out.println("Does the graph contain a cycle? " + hasCycle(V, edges));
    }
}
