package Binary_Tree.Traversals;
import Binary_Tree.TreeNode;
import java.util.*;
/*
103. Binary Tree Zigzag Level Order Traversal
Solved
Medium

Topics
premium lock icon
Companies
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
 */

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int flag = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int i = 0;
            List<Integer> list = new ArrayList<>(size);

            while(i < size){
                TreeNode node = q.poll();
                if(flag == 0){
                    list.addLast(node.val);
                }
                else{
                    list.addFirst(node.val);
                }

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                i++;
            }
            ans.add(list);

            flag = flag == 0 ? 1 : 0;
        }
        return ans;

    }
}
