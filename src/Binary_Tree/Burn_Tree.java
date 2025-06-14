package Binary_Tree;
import java.util.*;
/*

2385. Amount of Time for Binary Tree to Be Infected

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.
 */

/*
------------------Topic ---
1. searching the node in bfs
2. bfs along with parent node

 */
public class Burn_Tree {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode , TreeNode> map = new HashMap<>();

        TreeNode[] ans = new TreeNode[1];
        dfs(root , start ,ans , map);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(ans[0]);
        int res = -1;
        Set<TreeNode> set = new HashSet<>();
        while(!q.isEmpty()){
            int s = q.size();
            int i = 0;
            while(i < s){
                TreeNode node= q.poll();
                set.add(node);
                if(map.containsKey(node) && !set.contains(map.get(node))){
                    q.offer(map.get(node));
                }
                if(node.left != null && !set.contains(node.left)){
                    q.offer(node.left);
                }
                if(node.right != null && !set.contains(node.right)){
                    q.offer(node.right);
                }

                i++;
            }
            res++;
        }
        return res;
    }
    public void dfs(TreeNode root , int k , TreeNode[] ans , Map<TreeNode , TreeNode> map){
        if(root == null)return;
        if(root.val == k)ans[0] = root;
        if(root.left != null){
            map.put(root.left , root);
            dfs(root.left, k , ans , map);
        }
        if(root.right != null){
            map.put(root.right , root);
            dfs(root.right , k , ans , map);
        }

    }
}
