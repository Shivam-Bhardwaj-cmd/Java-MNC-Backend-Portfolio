package day49;

import java.util.*;

public class JohnsonAlgorithm {

    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void johnson(int V, List<Edge> edges) {
        int[] h = new int[V];
        if (!bellmanFord(V, edges, h)) {
            System.out.println("Graph contains a negative weight cycle!");
            return;
        }

        // Step 2: Reweight all edges
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (Edge e : edges) {
            int newWeight = e.weight + h[e.from] - h[e.to];
            adj.get(e.from).add(new Edge(e.from, e.to, newWeight));
        }

        // Step 3: Run Dijkstra for each vertex
        for (int src = 0; src < V; src++) {
            int[] dist = dijkstra(V, adj, src);
            System.out.println("Shortest distances from vertex " + src + ":");
            for (int i = 0; i < V; i++) {
                int realDist = (dist[i] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : dist[i] - h[src] + h[i];
                System.out.println("  To " + i + " → " + (realDist == Integer.MAX_VALUE ? "INF" : realDist));
            }
            System.out.println();
        }
    }

    // Bellman-Ford step to compute reweight function h[]
    private static boolean bellmanFord(int V, List<Edge> edges, int[] h) {
        Arrays.fill(h, 0);
        for (int i = 0; i < V - 1; i++) {
            for (Edge e : edges) {
                if (h[e.from] + e.weight < h[e.to]) {
                    h[e.to] = h[e.from] + e.weight;
                }
            }
        }
        for (Edge e : edges) {
            if (h[e.from] + e.weight < h[e.to]) {
                return false;
            }
        }
        return true;
    }

    private static int[] dijkstra(int V, List<List<Edge>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (Edge edge : adj.get(u)) {
                int newDist = dist[u] + edge.weight;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.add(new int[]{edge.to, newDist});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 1));
        edges.add(new Edge(2, 1, 2));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(2, 3, 5));
        edges.add(new Edge(3, 4, 3));

        johnson(V, edges);
    }
}
