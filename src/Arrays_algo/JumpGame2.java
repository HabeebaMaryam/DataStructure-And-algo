package Arrays_algo;
import java.util.*;
public class JumpGame2 {
    public static void calculateJumps(int[] jump , int n ){
        int dp[] = new int[n];
        Arrays.fill(dp , Integer.MAX_VALUE-1);
        int i = n-2;
        dp[n-1] = 0;
        while(i >= 0){
            int j = 1;
            while(j <= jump[i] && i+j < n){
                dp[i] = Math.min(dp[i+j]+1 , dp[i]);
                j++;
            }
            i--;
        }
        System.out.println("Jump counts : " + dp[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Enter the N value
        System.out.println("Enter the value of N : ");
        int n = sc.nextInt();

        //take array as input
        System.out.println("Enter the Array Elements:");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        calculateJumps(arr , n);
    }

}
