package day53;

import java.util.*;

public class DAGPathCountDP {
    private int vertices;
    private List<List<Integer>> adj;

    public DAGPathCountDP(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int next : adj.get(v)) {
            if (!visited[next])
                topologicalSortUtil(next, visited, stack);
        }
        stack.push(v);
    }

    public int countPaths(int src, int dest) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        int[] dp = new int[vertices];
        dp[src] = 1;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int next : adj.get(u)) {
                dp[next] += dp[u];
            }
        }

        return dp[dest];
    }

    public static void main(String[] args) {
        DAGPathCountDP g = new DAGPathCountDP(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println("Number of paths from 0 to 5: " + g.countPaths(0, 5));
    }
}
