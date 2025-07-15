package Arrays_algo;

import java.util.Scanner;

public class Container_with_most_water {
    public static void calculateContainer(int[] arr , int n ){
        int ans = Integer.MIN_VALUE;
        int i = 0 , j = n-1;
        while(i < j){
            ans = Math.max(ans , Math.min(arr[i] , arr[j]) * (j-i));
            if(arr[i] < arr[j]){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println("Area : " + ans);
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
        calculateContainer(arr , n);
    }
}
