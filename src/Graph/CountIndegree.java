package Graph;
import java.util.*;
public class CountIndegree {
    public int[] indegree(ArrayList<ArrayList<Integer>> list , int nodes){
        int[] indeg = new int[nodes];

        for(int i = 0; i < nodes; i++){
            for(int elem : list.get(i)){
                indeg[elem]++;
            }
        }

        return indeg;
    }
}
