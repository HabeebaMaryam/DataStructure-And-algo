package Binary_Tree;
import java.util.*;
public class RootToNode {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        DFS(root , ans , list);
        return ans;

    }
    public void DFS(TreeNode root , List<List<Integer>> ans , List<Integer> list){
        list.add(root.val);
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if(root.left != null){
            DFS(root.left , ans , list);
        }
        if(root.right != null){
            DFS(root.right , ans ,list);
        }
        list.remove(list.size() - 1);
    }
    public void print(List<List<Integer>> ans){
        int n = ans.size();
        for(int i =0; i < n; i++){
            List<Integer> l = ans.get(i);
            for(int elem : l){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        RootToNode solution = new RootToNode();

        // Get the boundary traversal
        List<List<Integer>> result = solution.allRootToLeaf(root);

        // Print the result
        System.out.print("Boundary Traversal: \n");
        solution.print(result);
    }
}
