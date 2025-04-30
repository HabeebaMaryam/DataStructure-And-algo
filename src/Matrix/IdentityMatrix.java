package Matrix;

public class IdentityMatrix {
    public static boolean identityCheck(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        if(n != m){
            return false;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((i != j && arr[i][j] == 1) || (i == j && arr[i][j] == 0)){
                    return false;
                }
            }
        }
        return  true;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1 , 0 , 0},
                {0 , 1 , 0},
                {0 , 0 , 1}
        };
        System.out.println(identityCheck(arr));
    }
}
