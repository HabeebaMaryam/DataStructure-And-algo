package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement {
    public static void main(String[] args) {
        int[] ans = nextGreater(new int[]{3,10,4,2,1,2,6,1,7,2,9});
        System.out.println(Arrays.toString(ans));
    }
    public static int[] nextGreater(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--){
            int elem = arr[i];
            while(!st.isEmpty() && st.peek() <= elem){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            else{
                ans[i] = -1;
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
