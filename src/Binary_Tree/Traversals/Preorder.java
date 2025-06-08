package Binary_Tree.Traversals;

import Binary_Tree.Node;

public class Preorder {
    public void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
