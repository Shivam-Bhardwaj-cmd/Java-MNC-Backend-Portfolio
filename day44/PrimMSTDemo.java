package day44;

import java.util.*;

public class PrimMSTDemo {
    public static void main(String[] args) {
        int n = 5;
        int[][] graph = {
            {0,2,0,6,0},
            {2,0,3,8,5},
            {0,3,0,0,7},
            {6,8,0,0,9},
            {0,5,7,9,0}
        };

        boolean[] inMST = new boolean[n];
        int[] key = new int[n];
        int[] parent = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for(int count=0; count<n-1; count++){
            int u = minKey(key, inMST);
            inMST[u] = true;

            for(int v=0; v<n; v++){
                if(graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]){
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Edges in MST:");
        for(int i=1;i<n;i++){
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
        }
    }

    private static int minKey(int[] key, boolean[] mstSet){
        int min = Integer.MAX_VALUE, minIndex=-1;
        for(int v=0; v<key.length; v++){
            if(!mstSet[v] && key[v] < min){
                min = key[v]; minIndex=v;
            }
        }
        return minIndex;
    }
}
