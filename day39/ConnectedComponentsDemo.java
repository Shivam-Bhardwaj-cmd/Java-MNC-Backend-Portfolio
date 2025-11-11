package day39;

import java.util.*;

public class ConnectedComponentsDemo {

    private static void dfs(GraphBasics graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.getNeighbors(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static int countConnectedComponents(GraphBasics graph) {
        boolean[] visited = new boolean[graph.getVertices()];
        int count = 0;

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GraphBasics graph = new GraphBasics(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);

        System.out.println("Graph:");
        graph.printGraph();

        int components = countConnectedComponents(graph);
        System.out.println("Number of connected components: " + components);
    }
}
