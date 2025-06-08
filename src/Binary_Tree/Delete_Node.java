package Binary_Tree;
import java.util.*;
/*
Given a binary tree with nodes where all elements are unique, implement a function that deletes a node with
 a specified value (key) from the tree. When a node is deleted, the tree should shrink from the bottom, meaning
  the deleted node is replaced by the bottom-most, right-most node in the tree. After deletion, the binary tree
   will be printed using in-order traversal.

 */


public class Delete_Node {

    public Node deleteNode(Node root, int key) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            if (root.data == key) return null;
            else return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node keyNode = null, temp = null, lastParent = null;

        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.data == key) {
                keyNode = temp;
            }
            if (temp.left != null) {
                lastParent = temp;
                q.add(temp.left);
            }
            if (temp.right != null) {
                lastParent = temp;
                q.add(temp.right);
            }
        }

        if (keyNode != null) {
            keyNode.data = temp.data; // Replace key node data with deepest node data

            // Delete deepest node directly using lastParent
            if (lastParent.left == temp) {
                lastParent.left = null;
            } else if (lastParent.right == temp) {
                lastParent.right = null;
            }
        }

        return root;
    }

}
