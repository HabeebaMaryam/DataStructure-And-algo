package Binary_Search;
import java.util.*;
/*
2616. Minimize the Maximum Difference of Pairs
You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the
maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the
 p pairs.

Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where
 |x| represents the absolute value of x.

Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
 */
public class Min_maxPairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int max = 0;
        int n = nums.length;
        int start = 0 , end = nums[n-1] - nums[0];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(containsPair(nums , mid , p)){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }
    public boolean containsPair(int[] nums , int diff , int pair){
        int ans = 0;
        int i = 1 , n = nums.length;
        while(i < n){
            if(nums[i] - nums[i-1] <= diff){
                ans++;
                i += 2;
            }
            else{
                i++;
            }
        }
        return ans >= pair;
    }
}
