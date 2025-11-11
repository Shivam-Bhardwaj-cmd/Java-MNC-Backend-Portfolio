package day42;

import java.util.*;

class EdgeK implements Comparable<EdgeK> {
    int from, to, weight;

    public EdgeK(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(EdgeK other) {
        return this.weight - other.weight;
    }
}

class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
    }

    public int find(int x) {
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if(xr==yr) return false;
        if(rank[xr]<rank[yr]) parent[xr]=yr;
        else if(rank[xr]>rank[yr]) parent[yr]=xr;
        else { parent[yr]=xr; rank[xr]++; }
        return true;
    }
}

public class KruskalMSTDemo {
    public static void kruskalMST(List<EdgeK> edges, int V) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(V);
        int mstWeight = 0;

        for(EdgeK e : edges) {
            if(uf.union(e.from, e.to)) {
                mstWeight += e.weight;
            }
        }

        System.out.println("Total weight of MST (Kruskal): " + mstWeight);
    }

    public static void main(String[] args) {
        int V = 5;
        List<EdgeK> edges = new ArrayList<>();
        edges.add(new EdgeK(0,1,2));
        edges.add(new EdgeK(0,3,6));
        edges.add(new EdgeK(1,2,3));
        edges.add(new EdgeK(1,3,8));
        edges.add(new EdgeK(1,4,5));
        edges.add(new EdgeK(2,4,7));

        kruskalMST(edges, V);
    }
}
