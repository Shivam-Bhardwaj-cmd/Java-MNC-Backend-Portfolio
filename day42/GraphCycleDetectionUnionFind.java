package day42;

import java.util.*;

@SuppressWarnings("unused")
class UnionFindCycle {
    int[] parent, rank;
    public UnionFindCycle(int n) {
        parent = new int[n]; rank = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
    }

    public int find(int x) {
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if(xr==yr) return false; // cycle detected
        if(rank[xr]<rank[yr]) parent[xr]=yr;
        else if(rank[xr]>rank[yr]) parent[yr]=xr;
        else { parent[yr]=xr; rank[xr]++; }
        return true;
    }
}

public class GraphCycleDetectionUnionFind {
    public static boolean hasCycle(int V, int[][] edges) {
        UnionFindCycle uf = new UnionFindCycle(V);
        for(int[] e : edges) {
            if(!uf.union(e[0], e[1])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0,1},{1,2},{2,3},{3,0}}; // contains cycle
        System.out.println("Graph has cycle: " + hasCycle(V, edges));
    }
}
