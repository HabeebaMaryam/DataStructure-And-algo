package Binary_Tree;
import java.util.Queue;
import java.util.LinkedList;
/*
662. Maximum Width of Binary Tree
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes)
, where the null nodes between the end-nodes that would be present in a complete binary tree extending down to
that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.
 */

public class Max_width {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root , 0));
        int ans = 0;
        while(!q.isEmpty()){
            int min = q.peek().val;
            int s = q.size();
            int i = 0 , first = min , last = min;
            while(i < s){
                pair p = q.poll();
                int val = p.val;
                TreeNode node = p.root;

                if(i == 0){
                    first = val - min;
                }
                if(i == s - 1){
                    last = val - min;
                }
                if(node.left != null){
                    q.offer(new pair(node.left , 2 * val + 1));
                }
                if(node.right != null){
                    q.offer(new pair(node.right , 2 * val + 2));
                }
                i++;
            }
            ans = Math.max(ans , last - first + 1);
        }
        return ans;
    }
}
 class pair{
    TreeNode root ;
    int val;
    pair(TreeNode node ,int v){
        root = node;
        val = v;
    }
}
