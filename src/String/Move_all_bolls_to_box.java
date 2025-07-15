package String;

import java.util.Arrays;

public class Move_all_bolls_to_box {
    public static int[] func(String s){
        int n = s.length();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                for(int j = 0; j < n; j++){
                    ans[j] += Math.abs(i - j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0};
        System.out.println(Arrays.toString(func("001011")));
    }

}
