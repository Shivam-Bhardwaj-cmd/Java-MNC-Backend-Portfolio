package day60;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] t : times)
            adj.get(t[0]).add(new int[]{t[1], t[2]});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];
            if (time > dist[node]) continue;
            for (int[] nbr : adj.get(node)) {
                int newTime = time + nbr[1];
                if (newTime < dist[nbr[0]]) {
                    dist[nbr[0]] = newTime;
                    pq.offer(new int[]{nbr[0], newTime});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++)
            if (dist[i] == Integer.MAX_VALUE) return -1;
            else max = Math.max(max, dist[i]);

        return max;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        System.out.println("Network Delay Time: " + new NetworkDelayTime().networkDelayTime(times, n, k));
    }
}
