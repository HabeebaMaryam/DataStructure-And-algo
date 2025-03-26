package Graph;
import java.util.*;
public class KHANS_ALGO {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

//        khansAlgo(adj , V);

        TOPO_SORT topo = new TOPO_SORT();

        topo.topoSort(adj , V);


    }
    public static void khansAlgo(ArrayList<ArrayList<Integer>> list , int nodes){
        CountIndegree indegre_obj= new CountIndegree();// create indegree object
        int[] indegree = indegre_obj.indegree(list , nodes);

//        find the nodes with zero indegree and store it in list
        ArrayList<Integer> zeroIndegree = new ArrayList<>();
        for(int i = 0; i < nodes; i++){
            if(indegree[i] == 0){
                zeroIndegree.add(i);
            }
        }

        while(!zeroIndegree.isEmpty()){
            int size = zeroIndegree.size();
            int curr = zeroIndegree.get(size - 1);
            zeroIndegree.remove(--size);
            System.out.println(curr);
            for(int elem : list.get(curr)){
                indegree[elem]--;
                if (indegree[elem] == 0){
                    zeroIndegree.add(elem);
                }
            }
        }
    }
}
