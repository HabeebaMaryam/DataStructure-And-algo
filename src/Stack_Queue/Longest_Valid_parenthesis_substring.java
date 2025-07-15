package Stack_Queue;

import java.util.Stack;

public class Longest_Valid_parenthesis_substring {
    public int LongestValidParenthesis(String s ){
        int n = s.length();
        int ans = 0;
        Stack<Integer> stack= new Stack<>();
        stack.push(-1);
        int i = 0;
        while(i < n){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    ans = Math.max(ans , i- stack.peek() );
                }
                else{
                    stack.push(i);
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = ")()())()()()()";
        Longest_Valid_parenthesis_substring obj = new Longest_Valid_parenthesis_substring();
        System.out.println(obj.LongestValidParenthesis(s));
    }
}
