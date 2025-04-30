package Matrix;

public class SparseMatrix {
    public static void printSparse(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != 0){
                    System.out.print(i + "\t" + j +"\t" + arr[i][j]+"\n");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
                {0 , 0 , 3 , 0 , 4 },
                {0 , 0 , 5 , 7 , 0 },
                {0 , 0 , 0 , 0 , 0 },
                {0 , 2 , 6 , 0 , 0 }
        };
        printSparse(arr);
    }
}
