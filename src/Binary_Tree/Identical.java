package Binary_Tree;
/*
100. Same Tree
Solved
Easy

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

public class Identical {
    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null){
            return true;
        }
        else if(p == null || q == null){
            return false;
        }

        if(p.data == q.data && isSameTree(p.left , q.left) && isSameTree(p.right , q.right)){
            return true;
        }
        return false;
    }
}
