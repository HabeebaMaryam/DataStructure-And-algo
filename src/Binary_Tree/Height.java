package Binary_Tree;

public class Height {
    public static void main(String[] args) {
        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.right = new Node(4);
        System.out.println("Height : " + height(root));
    }

    public static int height(Node node ){
        if(node == null){
            return -1;
        }
        return Math.max(height(node.left) , height(node.right)) + 1;
    }
}


// Time complexity : O(n);
// space complexity : O(h);
