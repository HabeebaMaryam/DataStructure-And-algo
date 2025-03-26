package FileHandling;

public class question2 {
    public static void main(String[] args) {
        System.out.println(function(12456));
    }
    public static int function(int num){
        int ans = 0;
        while(num!=0){
            int rem = num % 10;
            ans = (ans * 10) + rem ;

            num = num / 10;
        }
        return ans;
    }
}
