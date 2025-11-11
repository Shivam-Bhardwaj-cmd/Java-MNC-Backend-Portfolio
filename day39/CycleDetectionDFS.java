package day39;

import java.util.*;

@SuppressWarnings("unused")
public class CycleDetectionDFS {

    private static boolean dfs(GraphBasics graph, int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor : graph.getNeighbors(node)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, visited, node)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(GraphBasics graph) {
        boolean[] visited = new boolean[graph.getVertices()];

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, -1)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphBasics graph = new GraphBasics(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0); // creates a cycle
        graph.addEdge(3, 4);

        System.out.println("Graph:");
        graph.printGraph();

        boolean cycleExists = hasCycle(graph);
        System.out.println("Cycle exists? " + cycleExists);
    }
}
