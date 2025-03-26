package Bcktracking;

public class Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean t =  sudoku(board);
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    public static boolean sudoku(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(isValid(i , j , ch , board)){
                            board[i][j] = ch;
                            if(sudoku(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }

                    }
                    return false;
                }

            }
        }
        return true;
    }
    public static boolean isValid(int row, int col , char ch , char[][] board){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == ch){
                return false;
            }
            if(board[i][col] == ch){
                return false;
            }
            if(board[3 * (row/3) + i/3][3 * (col/3) + i % 3] == ch){
                return false;
            }
        }
        return true;
    }
}
