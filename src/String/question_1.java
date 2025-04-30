package String;

import java.util.Scanner;

public class question_1 {
    public static void main(String[] args) {
        System.out.println("enter the string : \n");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            System.out.println(ch + ": " + (int)ch);


        }
        System.out.println(s.codePointAt(0));
        System.out.println(Character.codePointAt(s.toCharArray() , 3,6));
    }
}
