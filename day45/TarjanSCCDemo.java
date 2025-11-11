package day45;

import java.util.*;

public class TarjanSCCDemo {
    private int vertices;
    private List<List<Integer>> adjList;
    private int time;
    private int[] disc, low;
    private boolean[] stackMember;
    private Stack<Integer> stack;

    public TarjanSCCDemo(int v) {
        this.vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        disc = new int[v];
        low = new int[v];
        stackMember = new boolean[v];
        stack = new Stack<>();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
    }

    void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    void sccUtil(int u) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        stackMember[u] = true;

        for (int v : adjList.get(u)) {
            if (disc[v] == -1) {
                sccUtil(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // Root node found
        if (low[u] == disc[u]) {
            System.out.print("SCC: ");
            while (true) {
                int w = stack.pop();
                stackMember[w] = false;
                System.out.print(w + " ");
                if (w == u) break;
            }
            System.out.println();
        }
    }

    public void tarjanSCC() {
        for (int i = 0; i < vertices; i++) {
            if (disc[i] == -1) sccUtil(i);
        }
    }

    public static void main(String[] args) {
        TarjanSCCDemo graph = new TarjanSCCDemo(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        graph.tarjanSCC();
    }
}
