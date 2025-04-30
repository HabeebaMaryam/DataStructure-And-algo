package Matrix;
// Question ------ Sort Row wise ans  colum wise

import java.util.Arrays;

/*
Algorithm
1.sort each row of matrix
2.Transpose the matrix
3.sort each row of matrix
4.Transpose the matrix again
 */
public class sortRowAndColumnWise {
    public void transpose(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] t = new int[n][m];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j <m; j++){
//                t[i][j] = arr[i][j];
//            }
//        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < m; j++){
                swap(arr , i , j);
            }
        }
    }
    public void swap(int[][] arr, int i , int j){
        int elem = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = elem;
    }
    public void sortRowWise(int[][] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            Arrays.sort(arr[i]);
        }
    }
    public void displayMatrix(int [][]arr){
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i < n; i++){
            for(int elem : arr[i]){
                System.out.print( elem+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
                {12, 7, 1, 8},
                {20, 9, 11, 2},
                {15, 4, 5, 13},
                {3, 18, 10, 6}
        };
        sortRowAndColumnWise obj = new sortRowAndColumnWise();
        System.out.println("Matrix before sorting : ");
        obj.displayMatrix(arr);
        obj.sortRowWise(arr);
        obj.transpose(arr);
        obj.sortRowWise(arr);
        obj.transpose(arr);

        System.out.println("Matrix after sorting : ");
        obj.displayMatrix(arr);

    }
}
