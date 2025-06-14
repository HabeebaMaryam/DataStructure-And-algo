package Binary_Tree;
import java.util.*;
public class distance_k {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        map.put(root , null);
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int i = 0;

            while(i<size){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    map.put(curr.left , curr);
                    q.add(curr.left);
                }
                if(curr.right != null){
                    map.put(curr.right , curr);
                    q.add(curr.right);
                }
                i++;
            }
        }

        Set<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        q2.add(target);

        int count = 0;
        while(count <= k){
            int size = q2.size();
            int i = 0;
            while(i < size){
                TreeNode curr = q2.poll();
                vis.add(curr);
                if(count == k)
                    ans.add(curr.val);

                if( curr.left != null && !vis.contains(curr.left)){
                    q2.add(curr.left);
                }
                if( curr.right != null && !vis.contains(curr.right)){
                    q2.add(curr.right);
                }
                if( map.get(curr) != null && !vis.contains(map.get(curr))){
                    q2.add(map.get(curr));
                }
                i++;
            }
            count++;
        }
        return ans;
    }
}
