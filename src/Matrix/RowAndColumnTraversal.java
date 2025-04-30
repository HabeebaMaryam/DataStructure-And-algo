package Matrix;
// Question --- Given a matrix of size MxN, you need to traverse the matrix both row-wise and column-wise and print the
// order of the elements for both the traversals.

/*
Questions based on similar concepts :
1. Find the maximum and minimum values in each row of a matrix.
2. Calculate the sum of each row and each column in a matrix.
3. Calculate the total sum of elements in a matrix.
4. Find the maximum and minimum values in each column of a matrix.
5. Add and subtract two matrices.
6. Print the boundary elements of a matrix. -- if(i == 0 || i == arr.length-1 || col == 0|| col == arr[0].length)
 */
public class RowAndColumnTraversal {

    public void rowTraversal(int[][] arr){
        int m = arr.length;
        for(int i = 0; i < m; i++) {
            for (int elem : arr[i]) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
    public void columnTraversal(int[][] arr){
        int n = arr[0].length;
        int m = arr.length;
        for(int col= 0; col < n; col++){
            for(int row= 0; row < m; row++){
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1 , 2 ,3} , {4 , 5 , 6} , {7 , 8 , 9}};
        RowAndColumnTraversal obj = new RowAndColumnTraversal();
        obj.rowTraversal(arr);
        System.out.println();
        obj.columnTraversal(arr);
    }
}
