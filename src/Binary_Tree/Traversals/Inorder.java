package Binary_Tree.Traversals;

import Binary_Tree.Node;

public class Inorder {
    public void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
