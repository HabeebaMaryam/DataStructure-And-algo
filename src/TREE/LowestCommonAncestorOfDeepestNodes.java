/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair ans = LCA(root);
        return ans.root;
    }
    public Pair LCA(TreeNode root ){
        if(root == null)return new Pair(0 , new TreeNode());
        Pair left = LCA(root.left );
        Pair right = LCA(root.right);
        if(left.height == right.height ){
            return new Pair(left.height + 1 , root);
        }
        else if(left.height > right.height){
            return new Pair(left.height + 1 , left.root);
        }
        return new Pair(right.height + 1 , right.root);
    }
}
class Pair{
    int height ;
    TreeNode root;
    Pair(int h , TreeNode r){
        height = h;
        root = r;
    }
}
