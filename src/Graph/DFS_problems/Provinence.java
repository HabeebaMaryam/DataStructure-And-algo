package Graph.DFS_problems;
import java.util.*;
/*
547. Number of Provinces --- here the question is to understand that one dfs call results in visiting of all connected nodes
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
 */
public class Provinence {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    list.get(i+1).add(j+1);
                    list.get(j+1).add(i+1);
                }
            }
        }
        int ans = 0;
        boolean[] vis = new boolean[n+1];
        Arrays.fill(vis , false);
        for(int i = 1; i <=n; i++){
            if(!vis[i]){
                ans++;
                dfs( vis , i , list);
            }
        }
        return ans;

    }
    public void dfs(boolean[] vis , int node ,List<List<Integer>> adj){
        vis[node] = true;
        for(int elem : adj.get(node)){
            if(!vis[elem]){
                dfs(vis , elem , adj);
            }
        }
    }
}
