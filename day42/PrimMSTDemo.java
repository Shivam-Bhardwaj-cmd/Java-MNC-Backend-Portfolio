package day42;

import java.util.*;

class Edge implements Comparable<Edge> {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class PrimMSTDemo {
    public static void primMST(List<List<Edge>> graph, int V) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0)); // start from vertex 0
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (visited[current.to]) continue;
            visited[current.to] = true;
            mstWeight += current.weight;

            for (Edge neighbor : graph.get(current.to)) {
                if (!visited[neighbor.to]) {
                    pq.add(neighbor);
                }
            }
        }

        System.out.println("Total weight of MST (Prim): " + mstWeight);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Example edges
        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));

        graph.get(0).add(new Edge(3, 6));
        graph.get(3).add(new Edge(0, 6));

        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(1, 3));

        graph.get(1).add(new Edge(3, 8));
        graph.get(3).add(new Edge(1, 8));

        graph.get(1).add(new Edge(4, 5));
        graph.get(4).add(new Edge(1, 5));

        graph.get(2).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 7));

        primMST(graph, V);
    }
}
