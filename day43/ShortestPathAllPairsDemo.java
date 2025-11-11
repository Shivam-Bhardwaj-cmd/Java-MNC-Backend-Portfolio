package day43;

import java.util.*;

class EdgeSP {
    int from, to, weight;
    public EdgeSP(int from, int to, int weight) { this.from = from; this.to = to; this.weight = weight; }
}

public class ShortestPathAllPairsDemo {
    // Using multiple Dijkstra runs (sparse graph efficient approach)
    public static int[][] allPairsDijkstra(List<List<EdgeSP>> graph, int V) {
        int[][] allDist = new int[V][V];
        for(int i=0;i<V;i++) {
            allDist[i] = dijkstra(graph, i, V);
        }
        return allDist;
    }

    private static int[] dijkstra(List<List<EdgeSP>> graph, int src, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<EdgeSP> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new EdgeSP(src, src, 0));

        while(!pq.isEmpty()) {
            EdgeSP curr = pq.poll();
            int u = curr.to;
            int w = curr.weight;
            if(w > dist[u]) continue;

            for(EdgeSP neighbor : graph.get(u)) {
                if(dist[neighbor.to] > dist[u] + neighbor.weight) {
                    dist[neighbor.to] = dist[u] + neighbor.weight;
                    pq.add(new EdgeSP(u, neighbor.to, dist[neighbor.to]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<EdgeSP>> graph = new ArrayList<>();
        for(int i=0;i<V;i++) graph.add(new ArrayList<>());

        graph.get(0).add(new EdgeSP(0, 1, 3));
        graph.get(0).add(new EdgeSP(0, 3, 7));
        graph.get(1).add(new EdgeSP(1, 0, 8));
        graph.get(1).add(new EdgeSP(1, 2, 2));
        graph.get(2).add(new EdgeSP(2, 0, 5));
        graph.get(2).add(new EdgeSP(2, 3, 1));
        graph.get(3).add(new EdgeSP(3, 0, 2));

        int[][] allPairs = allPairsDijkstra(graph, V);
        System.out.println("All-pairs shortest paths:");
        for(int i=0;i<V;i++) System.out.println(Arrays.toString(allPairs[i]));
    }
}
