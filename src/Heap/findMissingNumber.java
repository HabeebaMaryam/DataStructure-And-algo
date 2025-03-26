package Heap;

public class findMissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{ 1,2 , 3 , 4 ,5, 6};
        System.out.println(binarysearch(arr));
    }
    public static int  binarysearch(int[] arr){
        int low = 0 , high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] != mid+1){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low+1;
    }
}
