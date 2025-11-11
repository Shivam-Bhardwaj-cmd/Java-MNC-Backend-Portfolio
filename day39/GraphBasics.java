package com.dsa.day39;

import java.util.*;

public class GraphBasics {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public GraphBasics(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add edge (directed)
    public void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
    }

    // Print graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int node : adjacencyList[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphBasics g = new GraphBasics(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Graph adjacency list:");
        g.printGraph();
    }
}
