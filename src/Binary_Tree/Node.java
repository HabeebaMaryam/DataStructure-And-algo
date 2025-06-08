package Binary_Tree;

public class Node {
    public int data;
    public Node left;
    public Node right ;
    Node(int val){
        data = val;
        left = null;
        right = null;
    }

    Node(int val , Node l , Node r){
        data = val ;
        left = l;
        right = r;
    }
}
