package day59;

import java.util.*;

public class CycleDetectionDirected {
    private int vertices;
    private List<List<Integer>> adj;

    public CycleDetectionDirected(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int node = 0; node < vertices; node++) {
            if (dfs(node, visited, recStack))
                return true;
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true; // cycle found
        if (visited[node]) return false; // already processed

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, visited, recStack))
                return true;
        }

        recStack[node] = false; // backtrack
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionDirected graph = new CycleDetectionDirected(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1); // cycle

        System.out.println("Graph has cycle: " + graph.isCyclic());
    }
}
