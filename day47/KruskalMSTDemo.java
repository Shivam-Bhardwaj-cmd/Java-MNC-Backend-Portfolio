package day47;

import java.util.*;

class WeightedEdge {
    int src, dest, weight;
    WeightedEdge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

class DisjointSetMST {
    private int[] parent, rank;

    public DisjointSetMST(int n) {
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

public class KruskalMSTDemo {
    public static void main(String[] args) {
        int V = 6;
        List<WeightedEdge> edges = Arrays.asList(
                new WeightedEdge(0, 1, 4),
                new WeightedEdge(0, 2, 3),
                new WeightedEdge(1, 2, 1),
                new WeightedEdge(1, 3, 2),
                new WeightedEdge(2, 3, 4),
                new WeightedEdge(3, 4, 2),
                new WeightedEdge(4, 5, 6)
        );

        edges.sort(Comparator.comparingInt(e -> e.weight));

        DisjointSetMST ds = new DisjointSetMST(V);
        List<WeightedEdge> mst = new ArrayList<>();

        for (WeightedEdge edge : edges) {
            int root1 = ds.find(edge.src);
            int root2 = ds.find(edge.dest);

            if (root1 != root2) {
                mst.add(edge);
                ds.union(root1, root2);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight = 0;
        for (WeightedEdge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
}
