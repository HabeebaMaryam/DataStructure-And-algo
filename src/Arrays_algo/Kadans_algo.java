package Arrays_algo;

import java.util.Scanner;

public class Kadans_algo {
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

        //Algo : 1 . maintains currMax = arr[0] and globalMax = arr[0]
        // 2. iterate over array by applying the formula - cMax = Math.max(cmax , arr[i] + cMax); gmax = Math.max(gmax , cmax)

        int cMax = arr[0];
        int gMax = arr[0];
        for(int i = 1; i < n; i++){
            cMax = Math.max(arr[i] , arr[i]+cMax);
            gMax = Math.max(cMax , gMax);
        }
        System.out.println("longest subArray sum : " + gMax);
    }
}
