package Segment_Tree;

public class RangeMaxIndex {
    public void buildSG(int[] nums , int[] seg , int l , int r , int ind){
        if(l == r){
            seg[ind] = l;
            return;
        }
        int mid = l + (r - l)/2;
        buildSG(nums , seg , l , mid , 2*ind+1);
        buildSG(nums , seg , mid+1 , r , 2*ind+2);

        int left = nums[seg[2*ind+1]];
        int right = nums[seg[2*ind+2]];
        if(left < right){
            seg[ind] = seg[2*ind+2];
        }
        else{
            seg[ind] = seg[2*ind+1];
        }

    }
    public int rangeMax(int[] nums ,int[] seg ,int start , int end , int ind , int l , int r){
        if(l > end || r < start){
            return -1;
        }
        if(l >= start && r <= end){
            return seg[ind];
        }
        int mid = l + (r - l)/2;
        int left = rangeMax(nums , seg , start , end , 2 * ind+1 , l , mid);
        int right = rangeMax(nums ,seg , start , end , 2 * ind+2 ,mid+1 , r);
        if(left == -1){
            return right;
        }
        if(right == -1){
            return left;
        }
        if(nums[left] < nums[right]){
            return right;
        }
        return left;
    }
    public int findLeftMost(int start , int end , int[] seg, int[] nums , int n){
        int l = end + 1;
        int r = n-1;
        int ans = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l)/2;
            int tmp = rangeMax(nums , seg, l , mid , 0 , 0 , n-1);
            if(nums[tmp] < Math.max(nums[start] , nums[end])){
                r = mid -1;
                ans = Math.min(tmp , ans);
            }
            else{
                l = mid+1;
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        RangeMaxIndex obj = new RangeMaxIndex();
        int[] nums = {5 , 3 , 6, 6, 7 , 4, 1 , 6};
        int[] seg = new int[4*4];
        obj.buildSG(nums , seg , 0 , 3 , 0);
        System.out.println(obj.rangeMax(nums , seg , 0 , 1 , 0 , 0 , 3));
        System.out.println(obj.findLeftMost(0, 1, seg, nums, nums.length));
    }
}
