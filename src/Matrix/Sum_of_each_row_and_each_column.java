package Matrix;

public class Sum_of_each_row_and_each_column {
    public void rowWiseSum(int[][] arr){
        int m = arr.length;
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for (int elem : arr[i]) {
                sum += elem;
            }
            System.out.printf("%d : %d \n" , i , sum);
        }
    }
    public void columnWiseSum(int[][] arr){
        int n = arr[0].length;
        int m = arr.length;
        for(int col= 0; col < n; col++){
            int sum = 0;
            for(int row= 0; row < m; row++){
                sum += arr[row][col];
            }
            System.out.printf("%d \t" ,sum);
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1 , 2 ,3} , {4 , 5 , 6} , {7 , 8 , 9}};
        Sum_of_each_row_and_each_column obj = new Sum_of_each_row_and_each_column();
        obj.rowWiseSum(arr);

        obj.columnWiseSum(arr);
    }
}
