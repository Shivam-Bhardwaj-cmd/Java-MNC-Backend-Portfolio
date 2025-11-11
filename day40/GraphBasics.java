package day40;

import java.util.ArrayList;
import java.util.List;

public class GraphBasics {

    private List<List<Edge>> adjacencyList;  // private, use getter

    public GraphBasics(int vertices) {
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjacencyList.get(u).add(new Edge(v, weight));
        adjacencyList.get(v).add(new Edge(u, weight)); // undirected graph
    }

    public List<List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public static class Edge {
        public int dest;
        public int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
