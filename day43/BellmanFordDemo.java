package day43;

import java.util.Arrays;

class EdgeBF {
    int from, to, weight;
    public EdgeBF(int from, int to, int weight) { this.from = from; this.to = to; this.weight = weight; }
}

public class BellmanFordDemo {
    public static void bellmanFord(EdgeBF[] edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0;i<V-1;i++) {
            for(EdgeBF e : edges) {
                if(dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight;
                }
            }
        }

        // Check for negative-weight cycles
        for(EdgeBF e : edges) {
            if(dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.weight < dist[e.to]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Shortest distances from source " + src + ": " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int V = 5;
        EdgeBF[] edges = {
                new EdgeBF(0, 1, -1),
                new EdgeBF(0, 2, 4),
                new EdgeBF(1, 2, 3),
                new EdgeBF(1, 3, 2),
                new EdgeBF(1, 4, 2),
                new EdgeBF(3, 2, 5),
                new EdgeBF(3, 1, 1),
                new EdgeBF(4, 3, -3)
        };
        bellmanFord(edges, V, 0);
    }
}
