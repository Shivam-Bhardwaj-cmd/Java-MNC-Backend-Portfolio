package day53;

import java.util.*;

public class DAGLongestPathDP {
    private int vertices;
    private List<List<int[]>> adj;

    public DAGLongestPathDP(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new int[]{v, weight});
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int[] edge : adj.get(v)) {
            if (!visited[edge[0]])
                topologicalSortUtil(edge[0], visited, stack);
        }
        stack.push(v);
    }

    public void longestPath(int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MIN_VALUE) {
                for (int[] edge : adj.get(u)) {
                    int v = edge[0];
                    int weight = edge[1];
                    if (dist[v] < dist[u] + weight) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        System.out.println("Longest distances from source " + src + ":");
        for (int i = 0; i < vertices; i++)
            System.out.println("Vertex " + i + " : " + (dist[i] == Integer.MIN_VALUE ? "INF" : dist[i]));
    }

    public static void main(String[] args) {
        DAGLongestPathDP g = new DAGLongestPathDP(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        g.longestPath(1);
    }
}
