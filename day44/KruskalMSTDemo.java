package day44;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    int[] parent, rank;
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
    }

    public int find(int u) {
        if(parent[u]!=u) parent[u] = find(parent[u]);
        return parent[u];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if(rootU == rootV) return;

        if(rank[rootU] < rank[rootV]) parent[rootU] = rootV;
        else if(rank[rootV] < rank[rootU]) parent[rootV] = rootU;
        else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}

public class KruskalMSTDemo {
    public static void main(String[] args) {
        int n = 4; // vertices
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,6));
        edges.add(new Edge(0,3,5));
        edges.add(new Edge(1,3,15));
        edges.add(new Edge(2,3,4));

        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(n);
        List<Edge> mst = new ArrayList<>();

        for(Edge e : edges) {
            if(ds.find(e.src) != ds.find(e.dest)) {
                mst.add(e);
                ds.union(e.src, e.dest);
            }
        }

        System.out.println("Edges in MST:");
        for(Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }
    }
}
