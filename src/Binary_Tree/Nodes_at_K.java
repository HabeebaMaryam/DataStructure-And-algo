package Binary_Tree;
import java.util.*;
/*

863. All Nodes Distance K in Binary Tree

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the
values of all nodes that have a distance k from the target node.

You can return the answer in any order.
 */
/*
Algo

1. create a map which contains parents of all node
2.
    1.usnig DFS
        apply dfs and keep track of vis node using map
        if you reach the k th distance then add that  node to res
        while returning remove that node from vis
     2. using DFS
        apply simple bfs along with vis set
        if you reach the k the leve . add all the element of queue to the res
 */
public class Nodes_at_K {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        dfs(root , map);
        int l = 0;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs2(target , k , map , set , 0 , list);
        return list;

    }
    public void dfs2(TreeNode root , int k , Map<TreeNode , TreeNode> map , Set<TreeNode> set , int l , List<Integer> list ){
        if(l > k)return;
        if(l == k){
            list.add(root.val);
        }
        set.add(root);

        if(root.left != null && !set.contains(root.left)){
            dfs2(root.left , k , map , set , l+1, list);
        }
        if(root.right != null && !set.contains(root.right)){
            dfs2(root.right , k , map , set , l+1, list );
        }
        TreeNode parent = map.get(root);
        if(parent != null && !set.contains(parent)){
            dfs2(parent , k , map , set , l+1, list );
        }
        set.remove(root);
    }
    public void dfs(TreeNode root ,  Map<TreeNode , TreeNode> map){
        if(root == null)return;
        if(root.left != null){
            map.put(root.left , root);
            dfs(root.left, map);
        }
        if(root.right != null){
            map.put(root.right , root);
            dfs(root.right , map);
        }

    }
}
