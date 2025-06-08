package Binary_Tree;

/*
Given a binary tree, determine if it is height-balanced.
 */
public class Balanced_Tree {
    public boolean isBalanced(Node root) {
        return height(root) == -1?false : true;
    }
    public int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        if(left == -1)return -1;
        int right = height(root.right);
        if(right == -1)return -1;
        if(Math.abs(right - left) > 1)return -1;
        return Math.max(left , right) + 1;
    }
}
