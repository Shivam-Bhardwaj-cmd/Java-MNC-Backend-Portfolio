package day54;

import java.util.*;

public class UnionFindCycleDetection {
    static class Edge {
        int src, dest;
        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    @SuppressWarnings("unused")
    private int vertices;
    private List<Edge> edges;
    private DisjointSet ds;

    public UnionFindCycleDetection(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
        ds = new DisjointSet(vertices);
    }

    public void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));
    }

    public boolean hasCycle() {
        for (Edge edge : edges) {
            int root1 = ds.find(edge.src);
            int root2 = ds.find(edge.dest);

            if (root1 == root2) {
                return true; // Cycle detected
            }
            ds.union(root1, root2);
        }
        return false;
    }

    public static void main(String[] args) {
        UnionFindCycleDetection g = new UnionFindCycleDetection(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1); // Cycle here

        System.out.println("Graph contains cycle? " + g.hasCycle());
    }
}
