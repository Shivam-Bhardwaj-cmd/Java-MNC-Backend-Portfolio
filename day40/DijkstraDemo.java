package day40;

import java.util.*;

public class DijkstraDemo {

    public static void main(String[] args) {
        int V = 5;
        GraphBasics g = new GraphBasics(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 3);

        dijkstra(V, g.getAdjacencyList(), 0);
    }

    public static void dijkstra(int V, List<List<GraphBasics.Edge>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            @SuppressWarnings("unused")
            int d = curr[1];

            for (GraphBasics.Edge edge : adj.get(u)) {
                int v = edge.dest;
                int w = edge.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }
}
