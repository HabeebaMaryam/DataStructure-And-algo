package Binary_Tree;

public class Diameter_Of_Tree {
    public int diameterOfBinaryTree(Node root) {
        int[] diam = {0};
        height(root , diam);
        return diam[0];
    }
    public int height(Node root , int[] diameter){
        if(root == null)return 0;
        int l = height(root.left , diameter);
        int r = height(root.right , diameter);
        diameter[0] = Math.max(diameter[0] , l+r);
        return Math.max(l , r)+1;
    }
}
