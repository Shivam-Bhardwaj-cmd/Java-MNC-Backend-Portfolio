package day59;

import java.util.*;

public class CycleDetectionUndirected {
    private int vertices;
    private List<List<Integer>> adj;

    public CycleDetectionUndirected(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int src, int dest) {
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[vertices];

        for (int node = 0; node < vertices; node++) {
            if (!visited[node]) {
                if (dfs(node, visited, -1))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, node))
                    return true;
            } else if (neighbor != parent) {
                return true; // found a cycle
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionUndirected graph = new CycleDetectionUndirected(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // cycle
        graph.addEdge(3, 4);

        System.out.println("Graph has cycle: " + graph.isCyclic());
    }
}
