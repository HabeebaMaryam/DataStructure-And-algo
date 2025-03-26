package Graph;

import java.util.Arrays;

public class DetectNegetiveCycle {
    public static boolean bellmonFord(int[][] edges , int V , int source){
        int[] dist = new int[V];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[source] = 0;

        for(int i = 0; i < V ; i++){
            for(int[] edge : edges){
                int node1 = edge[0];
                int node2 = edge[1];
                int weight = edge[2];

                if( dist[node1] != Integer.MAX_VALUE && dist[node1] + weight < dist[node2]){
                    if(i == V - 1){
                        return true;
                    }
                    dist[node2] = dist[node1] + weight;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 1},
                {1, 2, 4},
                {2, 3, -6},
                {3, 1, -2} // This edge creates a negative cycle
        };
        int V = 4;
        boolean result = bellmonFord(edges , V , 0);
        if(result){
            System.out.println("contains negetive cycle");
        }
        else
            System.out.println("doesnot contain negetive cycle");
    }
}
