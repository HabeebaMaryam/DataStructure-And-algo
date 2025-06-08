package Binary_Tree;
//Question : Given a binary tree and a key, the task is to
// insert the key into the binary tree at the first position available in level order manner.

import java.util.LinkedList;
import java.util.Queue;

public class Insertion_at_First {
    public Node insert(int key , Node root){
        Queue<Node> q= new LinkedList<>();
        if(root == null){
            root = new Node(key);
            return root;
        }
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            int size = q.size();
            int i = 0;
            while(i < size){
                if(node.left == null){
                    node.left = new Node(key);
                    break;
                }
                else if(node.right == null){
                    node.right = new Node(key);
                    break;
                }
                else{
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }
        return root;
    }
}
