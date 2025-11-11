package day42;

import java.util.*;

class EdgeD {
    int to, weight;
    public EdgeD(int to, int weight) { this.to = to; this.weight = weight; }
}

public class DijkstraWithPriorityQueue {
    public static void dijkstra(List<List<EdgeD>> graph, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<EdgeD> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new EdgeD(src, 0));

        while(!pq.isEmpty()) {
            EdgeD current = pq.poll();
            int u = current.to;
            int w = current.weight;

            if(w > dist[u]) continue;

            for(EdgeD neighbor : graph.get(u)) {
                if(dist[neighbor.to] > dist[u] + neighbor.weight) {
                    dist[neighbor.to] = dist[u] + neighbor.weight;
                    pq.add(new EdgeD(neighbor.to, dist[neighbor.to]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ": " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<EdgeD>> graph = new ArrayList<>();
        for(int i=0;i<V;i++) graph.add(new ArrayList<>());

        graph.get(0).add(new EdgeD(1, 2));
        graph.get(0).add(new EdgeD(3, 6));
        graph.get(1).add(new EdgeD(2, 3));
        graph.get(1).add(new EdgeD(3, 8));
        graph.get(1).add(new EdgeD(4, 5));
        graph.get(2).add(new EdgeD(4, 7));
        graph.get(3).add(new EdgeD(4, 9));

        dijkstra(graph, 0, V);
    }
}
