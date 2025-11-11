package day40;

import java.util.*;

public class DetectCycleGraph {

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // cycle

        System.out.println("Cycle detected: " + hasCycle(V, adj));
    }

    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, visited, recStack, adj)) return true;
        }
        return false;
    }

    private static boolean dfs(int u, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {
        visited[u] = true;
        recStack[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v] && dfs(v, visited, recStack, adj)) return true;
            else if (recStack[v]) return true;
        }

        recStack[u] = false;
        return false;
    }
}
