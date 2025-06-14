package Stack_Queue;

public class Array_implimentaionOfStack {
    private int size ;
    private int top = -1;
    int[] s;
    Array_implimentaionOfStack(int si ){
        s = new int[si];
    }
    public void push(int n ){
        if(top == s.length-1){
            System.out.println("stack is full");
        }
        else{
            top++;
            s[top] = n;
            System.out.printf("%d inserted " , n);
        }
    }

    public int getTop(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        else{
            return s[top];
        }
    }
    public void pop(){
        if(top == -1){
            System.out.println("Stack is Empty");

        }
        else{
            System.out.printf("%d removed" , s[top--]);
        }
    }
    public int getSize(){
        return top+1;
    }

    public static void main(String[] args) {
        Array_implimentaionOfStack stack = new Array_implimentaionOfStack(10);
        stack.getTop();
        stack.push(1);
        System.out.println(stack.getSize());
        stack.pop();

    }

}
