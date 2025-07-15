package String;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class genrateBinaryNumbers {
    // Use queue  - offer 1
    //1 . repeat the process
    //2 . pop element - print - append 0 add to queue , append 1 add to  queue
    //3. while popped element <= N

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number : ");
        int n = sc.nextInt();

        Queue<String> q = new LinkedList<>();
        q.offer("1");
        String s = Integer.toBinaryString(n);
        while(n-- > 0){
            String head = q.poll();
            System.out.println(head);
            q.offer(head+"0");
            q.offer(head+"1");
        }

    }
}
