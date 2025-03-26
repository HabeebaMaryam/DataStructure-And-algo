package Graph;

import java.util.ArrayList;

import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Pair1{
        int node;
        int weight;
        Pair1(int a , int b){
            node = a;
            weight = b;
        }
    }
    public static void prims(ArrayList<ArrayList<Pair1>> edges , int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair x , Pair y) -> x.weight - y.weight)
;
        ArrayList<int[]> mst = new ArrayList<>();
        int sum = 0;
        int[] vis = new int[V];
        pq.add(new Pair(0 , 0 , -1));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            if(vis[pair.node] == 1){
                continue;
            }
            int node = pair.node;
            int parent = pair.parent;
            int weight = pair.weight;

            vis[node] = 1;
            if(parent != -1) {
                mst.add(new int[]{node , parent});
            }
            sum += weight;

            for(Pair1 edge : edges.get(node)){
                int child = edge.node;
                int w = edge.weight;
                if(vis[child] == 0){
                    pq.add(new Pair(child , node , w));
                }
            }
        }
        System.out.println("sum : " + sum);
        for(int[] edge : mst){
            System.out.printf("%d -> %d \n " , edge[0] , edge[1]);
        }
    }
    static class Pair{
        int node;
        int parent ;
        int weight;
        Pair(int node , int parent , int weight){
            this.node = node ;
            this.parent = parent;
            this.weight = weight;
        }

    }


    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<Pair1>> graph = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 6);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 8);
        addEdge(graph, 1, 4, 5);
        addEdge(graph, 2, 4, 7);
        addEdge(graph, 3, 4, 9);

        prims(graph , V);
    }
    static void addEdge(ArrayList<ArrayList<Pair1>> graph, int u, int v, int weight) {
        graph.get(u).add(new Pair1(v, weight));
        graph.get(v).add(new Pair1(u, weight)); // Since the graph is undirected
    }
}
