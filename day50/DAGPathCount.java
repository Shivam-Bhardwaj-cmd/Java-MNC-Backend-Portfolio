package day50;

import java.util.*;

public class DAGPathCount {

    public static int countPaths(List<List<Integer>> graph, int src, int dest, int[] dp) {
        if (src == dest) return 1;
        if (dp[src] != -1) return dp[src];

        int count = 0;
        for (int next : graph.get(src))
            count += countPaths(graph, next, dest, dp);
        return dp[src] = count;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        graph.get(0).addAll(Arrays.asList(1, 2));
        graph.get(1).addAll(Arrays.asList(3));
        graph.get(2).addAll(Arrays.asList(3, 4));
        graph.get(3).addAll(Arrays.asList(5));
        graph.get(4).addAll(Arrays.asList(5));

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int totalPaths = countPaths(graph, 0, 5, dp);
        System.out.println("Total paths from 0 to 5: " + totalPaths);
    }
}
