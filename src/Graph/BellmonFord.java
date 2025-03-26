package Graph;

import java.util.Arrays;

public class BellmonFord {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                            {1, 3, 2},
                            {4, 3, -1},
                            {2, 4, 1},
                            {1, 2, 1},
                            {0, 1, 5}
        };
        int V = 5;
        int[] dist = bellmonFord(edges , V , 0);
        System.out.println(Arrays.toString(dist));
    }

    /*
    Algorithm
    1. define distance array and initialize with infinity
    2. for dist[source] = 0
    3. do total V - 1 iterations
        in each iteration relax each edege
        relaxing the edge :
        u ----> v with edge weight = w
        if(d[u] + w < d[v]){
            d[v] = d[u] + w ;
        }

      4. at n-1 cycle dist array contains the shortest path distance
      5 . if nth iteration results in update of dist array , it means graph contains negative cycle
     */
    public static int[] bellmonFord(int[][] edges , int V , int source){
        int[] dist = new int[V];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[source] = 0;

        for(int i = 0; i < V - 1; i++){
            for(int[] edge : edges){
                int node1 = edge[0];
                int node2 = edge[1];
                int weight = edge[2];

                if( dist[node1] != Integer.MAX_VALUE && dist[node1] + weight < dist[node2]){
                    dist[node2] = dist[node1] + weight;
                }
            }
        }
        return dist;
    }
}
