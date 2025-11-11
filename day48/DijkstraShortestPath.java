package day48;

import java.util.*;

public class DijkstraShortestPath {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int V, List<List<Edge>> adj, int src) {
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

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " → " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Edge(1, 10));
        adj.get(0).add(new Edge(4, 5));
        adj.get(1).add(new Edge(2, 1));
        adj.get(1).add(new Edge(4, 2));
        adj.get(2).add(new Edge(3, 4));
        adj.get(3).add(new Edge(0, 7));
        adj.get(4).add(new Edge(1, 3));
        adj.get(4).add(new Edge(2, 9));
        adj.get(4).add(new Edge(3, 2));

        dijkstra(V, adj, 0);
    }
}
