package BitManupulation;

public class FindNonRepatedElement2 {
    public static void main(String[] args) {
        int[] arr = {1 ,2, 3 , 1 , 2 ,4};
        findNonRepeted(arr , arr.length);
    }
    public static void  findNonRepeted(int[] arr , int n){
        int xor = 0;
        for(int elem : arr){
            xor = xor ^ elem;
        }

        // find first set bit
        int negXor = (-xor);
        int firstSetBit = xor & negXor;

        // find n1 and n2
        int n1 = 0 , n2 = 0;
        for(int elem : arr){
            if((elem & firstSetBit) != 0){
                n1 = n1 ^ elem;
            }
            else{
                n2 = n2 ^ elem;
            }
        }
        System.out.println("n1 == " + n1 + "\nn2 == "+ n2);
    }

}
