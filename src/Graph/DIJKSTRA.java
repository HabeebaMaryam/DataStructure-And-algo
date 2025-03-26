package Graph;

import java.util.*;

public class DIJKSTRA {
    public void Dijkstra(int V , ArrayList<ArrayList<Pair>> list , int src){
        int[] dist = new int[V+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> q =new PriorityQueue<>((Pair x , Pair y) -> x.dist - y.dist);
        q.add(new Pair(src , 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int d = p.dist;

            for(Pair neigh : list.get(node)){
                if(neigh.dist + d < dist[neigh.node]){
                    dist[neigh.node] = neigh.dist + d;
                    q.add(new Pair(neigh.node, neigh.dist + d));
                }
            }
        }

        for (int i = 1; i <= V; i++){
            System.out.printf("%d : %d\n" , i , dist[i]);
        }
    }
    public static void main(String[] args) {
        /*
        list contains Arraylist wher in each arrayList
            first element is node1
            second elemnt is node2
            third is weight of the edge connecting those 2 edges
         */
        Scanner sc = new Scanner(System.in);
        DIJKSTRA obj = new DIJKSTRA();
//        take no of nodes as input
        System.out.println("Enter the no of nodes:\n");
        int v = sc.nextInt();


        int[][] list = new int[][]{
                {1,2,2},
                {2,5,5},
                {2,3,4},
                {1,4,1},
                {4,3,3},
                {3,5,1}
        };
//        construct adj list
        ArrayList<ArrayList<Pair>> adj = obj.constructADJ(list , v);
        obj.Dijkstra(v , adj , 1);
    }
    public ArrayList<ArrayList<Pair>> constructADJ(int[][] list , int V){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < list.length; i++){
            int node1 = list[i][0];
            int node2 = list[i][1];
            int dist = list[i][2];
            adj.get(node1).add(new Pair(node2 , dist));
            adj.get(node2).add(new Pair(node1 , dist));
        }
        return adj;
    }


    class Pair{
        int node ;
        int dist;
        Pair(int a , int b){
            node = a;
            dist = b;
        }
    }


}
