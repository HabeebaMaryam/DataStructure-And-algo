package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {

/*
        Algorithm ---
        1 . use for loop to traverse all nodes / vertices
        2 . if node is not visited call dfs
        3. in dfs , mark the node as visited and get all neighbours of node ,
            if it's neighbour is already visited and not a parent it means there is a cycle
 */
    public boolean usinDFS(ArrayList<ArrayList<Integer>> list , int parent , int node , int[] vis ,int v)
    {
            vis[v] = 1;
            for(int elem : list.get(node)){
                if(vis[elem] == 1 && elem != parent){
                    return true;
                }
                usinDFS(list , node , elem , vis , v);
            }
            return false;
    }

    public boolean usingBFS(ArrayList<ArrayList<Integer>> list , int[] vis , int src){
        vis[src] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src , -1));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int node = p.node;
            int parent = p.parent;
            for(int elem : list.get(node)){
                if(vis[elem] == 1 && elem != parent){
                    return true;
                }
                else{
                    vis[elem] = 1;
                    queue.add(new Pair( elem , node));
                }
            }
        }
        return false;

    }
    class Pair{
        int node ;
        int parent ;
        Pair(int a , int b){
            node = a;
            parent = b;
        }
    }

}
