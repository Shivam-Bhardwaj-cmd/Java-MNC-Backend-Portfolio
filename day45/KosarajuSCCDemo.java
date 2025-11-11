package day45;

import java.util.*;

public class KosarajuSCCDemo {

    private int vertices;
    private List<List<Integer>> adjList;

    public KosarajuSCCDemo(int v) {
        this.vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    void dfs(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adjList.get(v)) {
            if (!visited[n]) dfs(n, visited, stack);
        }
        stack.push(v);
    }

    void dfsTranspose(int v, boolean[] visited, List<List<Integer>> transposedGraph) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : transposedGraph.get(v)) {
            if (!visited[n]) dfsTranspose(n, visited, transposedGraph);
        }
    }

    public void printSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        // Step 1: Fill stack according to finish times
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) dfs(i, visited, stack);
        }

        // Step 2: Transpose the graph
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < vertices; i++) transpose.add(new ArrayList<>());
        for (int v = 0; v < vertices; v++) {
            for (int n : adjList.get(v)) {
                transpose.get(n).add(v);
            }
        }

        // Step 3: DFS on transposed graph in stack order
        Arrays.fill(visited, false);
        System.out.println("Strongly Connected Components:");
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                dfsTranspose(v, visited, transpose);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        KosarajuSCCDemo graph = new KosarajuSCCDemo(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        graph.printSCCs();
    }
}
