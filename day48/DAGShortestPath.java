package day48;

import java.util.*;

public class DAGShortestPath {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void shortestPathInDAG(int V, List<List<Edge>> adj, int src) {
        Stack<Integer> topo = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Topological sort
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSort(i, visited, adj, topo);
        }

        // Step 2: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: Relax vertices in topological order
        while (!topo.isEmpty()) {
            int u = topo.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge edge : adj.get(u)) {
                    if (dist[u] + edge.weight < dist[edge.to]) {
                        dist[edge.to] = dist[u] + edge.weight;
                    }
                }
            }
        }

        // Step 4: Print shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " → " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    private static void topologicalSort(int node, boolean[] visited, List<List<Edge>> adj, Stack<Integer> topo) {
        visited[node] = true;
        for (Edge edge : adj.get(node)) {
            if (!visited[edge.to])
                topologicalSort(edge.to, visited, adj, topo);
        }
        topo.push(node);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Edge(1, 2));
        adj.get(0).add(new Edge(4, 1));
        adj.get(4).add(new Edge(2, 3));
        adj.get(1).add(new Edge(2, 3));
        adj.get(2).add(new Edge(3, 6));
        adj.get(4).add(new Edge(5, 4));
        adj.get(5).add(new Edge(3, 1));

        shortestPathInDAG(V, adj, 0);
    }
}
