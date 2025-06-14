package TREE;
import java.util.*;
/*

386. Lexicographical Numbers

Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 */
public class Lexicographical_Numbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            dfs(i , n, ans);
        }
        return ans;
    }
    public void dfs(int index , int t , List<Integer> ans){
        if(index > t){
            return;
        }
        ans.add(index);
        for(int i =0 ; i <= 9; i++){
            int elem = index * 10 + i;
            if(elem > t)break;
            dfs(elem , t , ans);
        }
    }

}
