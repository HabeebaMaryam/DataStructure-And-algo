package Graph;

import java.util.ArrayList;

public class TOPO_SORT {
    public void topoSort(ArrayList<ArrayList<Integer>> list , int v){
        int[] vis = new int[v];
        ArrayList<Integer> ans = new ArrayList<>();
        DFS dfs = new DFS();
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfs.dfs(list , ans , vis , i);
            }
        }

        for(int elem : ans){
            System.out.println(elem);
        }
    }


}
