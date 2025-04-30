package Matrix;

public class Symmetric {
    public static boolean symmetric(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < m; j++){
                if(arr[i][j] != arr[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] arr1 = {
                {12, 7, 1, 8},
                {20, 9, 11, 2},
                {15, 4, 5, 13},
                {3, 18, 10, 6}
        };
        int[][] arr2 = {
                {2 , 3 , 6},
                {3 , 4 , 5},
                {6 , 5 , 9}
        };
        System.out.println(symmetric(arr2));
    }
}
