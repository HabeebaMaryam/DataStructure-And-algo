// 1390. Four Divisors
// Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.



class Solution {
    public int sumFourDivisors(int[] nums) {
        double ans = 0;
        for(int num : nums){
            ans += findDivisorSum(num);
        }
        return (int)ans;
    }
    public double findDivisorSum(int num){
        int ans = 0;
        int end = (int)Math.ceil(Math.sqrt(num));
        int count = 0;

        for(int i = 1; i < end; i++){
            if(num % i == 0){
                int other = (num / i);
                ans += i;
                if(other == i){
                    count ++;
                }
                else{
                    count += 2;
                    ans += other;
                }
                
                
                
                if(count > 4)return 0;
            }
        }
        return count == 4 ? ans : 0;
    }
}
