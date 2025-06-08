package Binary_Tree;
/*
124. Binary Tree Maximum Path Sum
Solved
Hard

Topics
premium lock icon
Companies
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass
through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class Max_Path_sum {
    public int maxPathSum(Node root) {
        int[] sum = {Integer.MIN_VALUE};
        height(root , sum);
        return sum[0];
    }
    public int height(Node root , int[] sum){
        if(root == null)return 0;
        int l = Math.max(0 , height(root.left , sum));
        int r = Math.max(0 , height(root.right , sum));
        sum[0] = Math.max(sum[0] , l+r+root.data);
        return Math.max(l , r)+root.data;
    }
}
