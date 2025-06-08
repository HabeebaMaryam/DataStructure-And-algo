/*
300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing subsequence.

*/
"https://leetcode.com/problems/longest-increasing-subsequence/description/"

  class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxlen = 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] <= dp[j] + 1){
                        dp[i] = dp[j]+1;
                    }
                    if(maxlen < dp[i]){
                        maxlen = dp[i];
                    }
                }
            }
        }
        return maxlen;
    }

}


// complexity 
time complexity - O(n * n);
space complexity - O(n)
