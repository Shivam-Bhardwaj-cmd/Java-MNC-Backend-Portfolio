import java.util.*;

public class DAGShortestPathDP {

    static class Edge {
        int to, weight;
        Edge(int t, int w) { to = t; weight = w; }
    }

    public static void shortestPathDAG(int n, List<List<Edge>> graph, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Stack<Integer> topo = topologicalSort(n, graph);

        while (!topo.isEmpty()) {
            int u = topo.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge e : graph.get(u)) {
                    if (dist[e.to] > dist[u] + e.weight) {
                        dist[e.to] = dist[u] + e.weight;
                    }
                }
            }
        }

        System.out.println("Shortest paths from source " + src + ":");
        for (int i = 0; i < n; i++)
            System.out.println("Node " + i + " : " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
    }

    private static Stack<Integer> topologicalSort(int n, List<List<Edge>> graph) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
            if (!visited[i])
                dfs(i, visited, stack, graph);
        return stack;
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Edge>> graph) {
        visited[node] = true;
        for (Edge e : graph.get(node))
            if (!visited[e.to])
                dfs(e.to, visited, stack, graph);
        stack.push(node);
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(4, 1));
        graph.get(1).add(new Edge(2, 3));
        graph.get(4).add(new Edge(2, 2));
        graph.get(2).add(new Edge(3, 6));
        graph.get(4).add(new Edge(5, 4));

        shortestPathDAG(n, graph, 0);
    }
}
