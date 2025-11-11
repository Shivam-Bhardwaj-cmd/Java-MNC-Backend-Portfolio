package day40;

import java.util.*;

public class MSTDemo {

    public static void main(String[] args) {
        int V = 5;
        GraphBasics g = new GraphBasics(V);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        primMST(V, g.getAdjacencyList());
    }

    public static void primMST(int V, List<List<GraphBasics.Edge>> adj) {
        boolean[] mstSet = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < V; i++) {
                if (!mstSet[i] && key[i] < min) {
                    min = key[i];
                    u = i;
                }
            }

            mstSet[u] = true;

            for (GraphBasics.Edge edge : adj.get(u)) {
                int v = edge.dest;
                int w = edge.weight;
                if (!mstSet[v] && w < key[v]) {
                    key[v] = w;
                    parent[v] = u;
                }
            }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + key[i]);
        }
    }
}
