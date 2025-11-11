package day40;

import java.util.*;

public class TopologicalSortDemo {

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topologicalSort(V, adj);
    }

    public static void topologicalSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, visited, stack, adj);
        }

        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }

    private static void dfs(int u, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) dfs(v, visited, stack, adj);
        }
        stack.push(u);
    }
}
