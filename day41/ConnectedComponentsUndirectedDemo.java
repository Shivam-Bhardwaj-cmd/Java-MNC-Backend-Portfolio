package day41;

import java.util.*;

public class ConnectedComponentsUndirectedDemo {

    public static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    public static int countConnectedComponents(int vertices, List<List<Integer>> adj) {
        boolean[] visited = new boolean[vertices];
        int count = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adj.add(new ArrayList<>());

        // Example edges (undirected)
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(3).add(4); adj.get(4).add(3);

        int components = countConnectedComponents(vertices, adj);
        System.out.println("Number of connected components: " + components);
    }
}
