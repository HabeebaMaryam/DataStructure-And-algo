package Binary_Tree;
import java.util.*;
/*
987. Vertical Order Traversal of a Binary Tree

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions
(row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each
column index starting from the leftmost column and ending on the rightmost column. There may be
multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 */

public class VerticalOrder {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a , b)->{
            int ans = a.y - b.y;
            if(ans == 0){
                ans = a.x - b.x;
                if(ans == 0){
                    ans = a.root.val - b.root.val;
                }
            }
            return ans;
        });
        q.offer(new Pair(root , 0 , 0));
        DFS(new Pair(root , 0 , 0 ) , q);
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.peek().y;
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty() && q.peek().y == curr){
                Pair p = q.poll();
                list.add(p.root.val);
            }
            ans.add(list);
        }
        return ans;
    }
    public void DFS(Pair root  ,PriorityQueue<Pair> q ){
        if(root.root == null){
            return;
        }
        TreeNode node = root.root;
        int x = root.x;
        int y = root.y;

        if(node.left != null){
            Pair p  = new Pair(node.left , x + 1 , y - 1);
            q.offer(p);
            DFS(p , q);
        }
        if(node.right != null){
            Pair p = new Pair(node.right , x + 1 , y + 1);
            q.offer(p);
            DFS(p , q);
        }

    }
}
class Pair{
    TreeNode root;
    int x;
    int y;
    Pair(TreeNode t , int x , int y){
        root = t;
        this.x = x;
        this.y = y;
    }
}
