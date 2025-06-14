package Binary_Search;
/* --- GFG --
Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat
all the bananas.

Each hour, Koko can choose one pile and eat up to s bananas from it.

If the pile has atleast s bananas, she eats exactly s bananas.

If the pile has fewer than s bananas, she eats the entire pile in that hour.

Koko can only eat from one pile per hour.

Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within
k hours.
 */
public class Koko_eating_Bananas {
    public int kokoEat(int[] arr, int k) {
        // code here
        int max = 0;
        for(int elem : arr){
            max = Math.max(elem , max);
        }
        int ans = 0;
        int start = 1 , end = max;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(canEat(arr , mid , k)){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return start;

    }
    public boolean canEat(int[] arr , int s , int k){
        int ans = 0;
        for(int elem : arr){
            ans += Math.ceil(elem/(double)s);
            if(ans > k){
                return false;
            }
        }
        return true;

    }
}
