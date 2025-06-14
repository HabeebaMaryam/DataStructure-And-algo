package GFG_Daily;
import java.util.*;
public class Exactly_one_swap {
    int countStrings(String s) {
        // code here
        int n = s.length();
        // Set<String> set = new HashSet<>();
        // for(int i = 0; i < n-1; i++){

        //     for(int j = i+1; j < n; j++){
        //          char[] arr = s.toCharArray();
        //         char ch = arr[i];
        //         arr[i] = arr[j];
        //         arr[j] = ch;
        //         set.add(new String(arr));
        //     }
        // }
        // return set.size();

        Map<Character , Integer> map = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0)+1);
        }
        int ans = 0;
        int c = 0;
        for(int val : map.values()){
            ans += (n - val)*val ;
            if(val > 1){
                c++;
            }
        }
        ans = (ans/2);
        if(c > 0)ans++;
        return ans;
    }
}
