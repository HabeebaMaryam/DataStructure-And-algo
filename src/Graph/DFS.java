package Graph;

import java.util.ArrayList;

public class DFS {
    public void dfs(ArrayList<ArrayList<Integer>> list , ArrayList<Integer> ans , int[] vis , int node){
        vis[node] = 1;
        for(int elem : list.get(node)){
            if(vis[elem] == 0){
                dfs(list , ans , vis , elem);
            }
        }
        ans.add(node);
    }
}
