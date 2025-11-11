package day56;

import java.util.*;

public class PrimMST {

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }

    public static int primMST(int V, List<List<Edge>> adj) {
        boolean[] inMST = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0)); // Start from node 0
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int weight = current.weight;

            if (inMST[node]) continue;

            inMST[node] = true;
            totalWeight += weight;

            for (Edge e : adj.get(node)) {
                if (!inMST[e.dest]) {
                    pq.add(new Pair(e.dest, e.weight));
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected weighted graph
        adj.get(0).add(new Edge(1, 2));
        adj.get(0).add(new Edge(3, 6));
        adj.get(1).add(new Edge(0, 2));
        adj.get(1).add(new Edge(2, 3));
        adj.get(1).add(new Edge(3, 8));
        adj.get(1).add(new Edge(4, 5));
        adj.get(2).add(new Edge(1, 3));
        adj.get(2).add(new Edge(4, 7));
        adj.get(3).add(new Edge(0, 6));
        adj.get(3).add(new Edge(1, 8));
        adj.get(4).add(new Edge(1, 5));
        adj.get(4).add(new Edge(2, 7));

        int mstWeight = primMST(V, adj);
        System.out.println("Total weight of MST (Prim’s Algorithm): " + mstWeight);
    }
}
