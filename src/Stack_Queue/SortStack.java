package Stack_Queue;

import java.util.Stack;

public class SortStack {
    public Stack<Integer> sortStack(Stack<Integer> s){
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        temp1.push(s.pop());
        while(!s.isEmpty()){
            int top = s.pop();
            if(top>temp1.peek()){
                temp1.push(top);
            }
            else{
                while(!temp1.isEmpty() && temp1.peek() > top){
                    temp2.push(temp1.pop());
                }
                temp1.push(top);
                while(!temp2.isEmpty()){
                    temp1.push(temp2.pop());
                }
            }

        }
        return temp1;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        SortStack obj = new SortStack();
        Stack<Integer> ans= new Stack<>();
        ans = obj.sortStack(s);
        while(!ans.isEmpty()){
            System.out.println(ans.pop());
        }
    }
}
