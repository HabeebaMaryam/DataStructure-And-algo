package Matrix;
// Question : Print the matrix in a zig-zag pattern.
public class ZigZag {
    public static void zigZag(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for(int i= 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i % 2 == 0){
                    System.out.print(arr[i][j]+" ");
                }
                else{
                    System.out.print(arr[i][m-1-j] +" ");
                }
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
        zigZag(arr);
    }
}
