package TREE;

/*
T - type
E - element (collections)
k - key
v - value
N - number

 */

import java.util.ArrayList;

public class TreeNode<T> {
     T data;
    TreeNode<T> left ;
    TreeNode<T> right;

    TreeNode(){
        left = null;
        right = null;
        data = null;
    }
    TreeNode(T V){
        this.data = V;
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        Preorder<Integer> obj = new Preorder<>();
        ArrayList<Integer> ans = obj.preorder(root , new ArrayList<>());
        for(Integer elem : ans){
            System.out.println(elem);
        }
    }
}
