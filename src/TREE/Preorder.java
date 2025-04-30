package TREE;

import java.util.ArrayList;

public class Preorder<T>{
    public ArrayList<T> preorder(TreeNode<T> root , ArrayList<T> ans){
        ans.add(root.data);
        if(root.left != null){
            preorder(root.left , ans);
        }
        if(root.right != null){
            preorder(root.right , ans);
        }
        return ans;

    }
}
