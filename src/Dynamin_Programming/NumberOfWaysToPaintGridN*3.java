/* 1411. Number of Ways to Paint N × 3 Grid
You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors: 
Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal 
sides have the same color).

Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be 
computed modulo 109 + 7.  */


class Solution {
    public int numOfWays(int n) {
        int mod = 1000000007;
        int[][][][] dp = new int[n+1][4][4][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    for(int m = 0; m < 4; m++){
                        dp[i][j][k][m] = -1;
                    }
                }
            }
        }
        return helper(0, 0, 0 , 0 , dp, mod, n);


    }
    public int helper(int row , int prev1, int prev2 , int prev3 , int[][][][] dp , int mod , int n ){
        if(row == n){
            return 1;
        }
        if(dp[row][prev1][prev2][prev3] != -1){
            return dp[row][prev1][prev2][prev3];
        }
        long ans = 0;
        for(int c1 = 1; c1 <=3; c1++){
            if(c1 == prev1)continue;
            for(int c2 = 1; c2 <=3 ; c2++){
                if(c2 == c1 || c2 == prev2)continue;
                for(int c3 = 1; c3 <= 3; c3++){
                    if(c3 == c2 || c3 == prev3)continue;
                    ans = (ans + helper(row + 1 , c1 , c2, c3 , dp , mod, n))%mod;
                }
            }
        }
        return dp[row][prev1][prev2][prev3] = (int)ans;
    }
}
