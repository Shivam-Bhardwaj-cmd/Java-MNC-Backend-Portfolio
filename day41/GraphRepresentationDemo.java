package day41;

import java.util.*;

public class GraphRepresentationDemo {
    public static void main(String[] args) {
        int vertices = 5;

        // Adjacency List
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) adjList.add(new ArrayList<>());

        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(3);

        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        // Adjacency Matrix
        int[][] adjMatrix = new int[vertices][vertices];
        adjMatrix[0][1] = 1;
        adjMatrix[1][2] = 1;
        adjMatrix[2][3] = 1;

        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
