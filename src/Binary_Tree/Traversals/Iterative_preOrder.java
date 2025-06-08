package Binary_Tree.Traversals;
import Binary_Tree.Node;

import java.util.Stack;

public class Iterative_preOrder {
    public void it_preOrder(Node root){
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node node = s.pop();
            System.out.print(node.data + " ");

            if(node.right != null)
                s.push(node.right);
            if(node.left != null){
                s.push(node.left);
            }
        }
    }
}

/*
ime Complexity: O(N) where N is the number of nodes in the binary tree. Every node of the binary tree
is visited exactly once, and for each node, , the operations performed (pushing and popping from the stack,
accessing node values, etc.) are constant time operations.

Space Complexity: O(N) where N is the number of nodes in the binary tree. This is because the stack can
potentially hold all nodes in the tree when dealing with a skewed tree (all nodes have only one child),
consuming space proportional to the number of nodes.
 */
