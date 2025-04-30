package Matrix;
// rint the upper triangle and lower triangle of a matrix.
public class PrintDiagnols {
    public void leftDg(int[][] arr){
        for(int i= 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(i == j){
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
    public void rightDg(int[][] arr){
//        rightDiagonol = columnLength - currentRow
        for(int i= 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(j == arr[0].length-1-i){
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1 ,2 , 3 , 10},
                        {4 ,5 ,6 , 11},
                        {7 , 8 , 9 , 12},
                        {13 , 14 , 15 , 16}};
        PrintDiagnols obj = new PrintDiagnols();
        obj.leftDg(arr);
        System.out.println();
        obj.rightDg(arr);
    }
}
