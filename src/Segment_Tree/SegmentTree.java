package Segment_Tree;

public class SegmentTree {
    public static int getSegmentTree(int[] nums , int[] seg , int ind , int left , int right){
        if(left == right){
            seg[ind] = nums[left];
            return seg[ind];
        }
        int mid = (left + right)/2;
        int left_ans = getSegmentTree(nums , seg , 2*ind +1 , left , mid);
        int right_ans = getSegmentTree(nums ,seg ,2*ind+2 , mid+1, right);
        seg[ind] = left_ans + right_ans;
        return seg[ind];
    }
    
    public static void main(String[] args) {
        int[] arr = {3 , 4 , 5 , 6};
        int[] seg = new int[2 * arr.length];
        System.out.println(getSegmentTree(arr , seg , 0 , 0 , arr.length - 1));
    }
}
