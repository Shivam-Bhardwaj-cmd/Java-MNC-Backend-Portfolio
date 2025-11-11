package day39;

import java.util.*;

public class DFSGraphDemo {

    private static void dfs(GraphBasics graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.getNeighbors(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphBasics graph = new GraphBasics(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        boolean[] visited = new boolean[graph.getVertices()];

        System.out.println("DFS Traversal starting from node 0:");
        dfs(graph, 0, visited);
        System.out.println();
    }
}
