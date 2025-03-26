package Graph;

import java.util.Scanner;

public class MatrixRrepresentation {
    public static int[][] makeMatrix(int node){
        int[][] matrix = new int[node][node];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < node; i++){
            for (int j = 0; j < node; j++){
                if(i == j){
                    matrix[i][j] = 0;
                    continue;
                }
                System.out.printf("Enter 1:if the edge is present b/w %d - %d \n 0 : edge not present\n" , i , j);
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int  j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes:");
        int nodes = sc.nextInt();

        int[][] adj_matrix = makeMatrix(nodes);
        printMatrix(adj_matrix);
        sc.close();
    }
}
