package Binary_Tree;
import com.sun.source.tree.Tree;

import java.util.*;

public class BoundryTraversal {
    public void addLeft(TreeNode root , List<Integer> list){
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left != null){
            list.add(root.val);
            addLeft(root.left , list);
        }
        else if(root.right != null){
            list.add(root.val);
            addLeft(root.right , list);
        }
    }
    public void addRight(TreeNode root , List<Integer> list){
        if(root.left == null && root.right == null){
            return;
        }
        list.add(root.val);
        if(root.right != null){
            addRight(root.right , list);
        }
        else if(root.left != null){
            addRight(root.left , list);
        }
    }
    public void addLeaf(TreeNode root , List<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        if(root.left != null){
            addLeaf(root.left , list);
        }
        if(root.right != null){
            addLeaf(root.right , list);
        }
    }
    public List<Integer> boundry(TreeNode root ){
        List<Integer> list = new ArrayList<>();
        addLeft(root , list);
        addLeaf(root , list);
        addRight(root.right , list);
        return list;
    }
    void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }


        public static void main(String[] args) {
            // Creating a sample binary tree
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);

            BoundryTraversal solution = new BoundryTraversal();

            // Get the boundary traversal
            List<Integer> result = solution.boundry(root);

            // Print the result
            System.out.print("Boundary Traversal: ");
            solution.printResult(result);
        }


}
