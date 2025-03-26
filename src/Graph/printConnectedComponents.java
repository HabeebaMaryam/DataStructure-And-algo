/*
Question --------
 Given an undirected graph edges, the objective is to return a list of all connected components.
 Each connected component should be represented as a list of its vertices, with all components returned in a
 collection where each component is listed separately.
 */

package Graph;
import java.util.*;
public class printConnectedComponents {

        public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
            return findComponents(v , edges);
        }
        public ArrayList<ArrayList<Integer>> findComponents(int v, int[][] edges){
            ArrayList<ArrayList<Integer>> list = constructList(edges , v);
            ArrayList<ArrayList<Integer>> L = new ArrayList<>();
            int[] vis = new int[v+1];
            for(int i = 0; i < v; i++){
                if(vis[i] == 0){
                    ArrayList<Integer> ans = new ArrayList<>();
                    dfs(v , vis , list , ans , i);
                    L.add(ans);
                }
            }
            return L;
        }
        public ArrayList<ArrayList<Integer>> constructList(int[][] edges , int v){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for(int i = 0; i < v; i++){
                list.add(new ArrayList<Integer>());
            }

            for(int i = 0; i < edges.length; i++){
                int elem1 = edges[i][0];
                int elem2 = edges[i][1];
                list.get(elem1).add(elem2);
                list.get(elem2).add(elem1);
            }
            return list;
        }
        public void dfs(int v, int[] vis ,ArrayList<ArrayList<Integer>> list , ArrayList<Integer> ans , int node){

            ans.add(node);
            vis[node] = 1;
            for(int val : list.get(node)){
                if(vis[val] == 0){
                    dfs(v , vis , list , ans , val);
                }
            }
        }

}
