package GFG_Daily;
import java.util.*;
public class Remove_the_balls {
    public int findLength(int[] color, int[] radius) {
        // code here
        List<Integer> l = new ArrayList<>();
        l.add(0);
        int n = color.length;
        int j = 1;
        while(j < n){
            int s = l.size();
            while(l.size() > 0 && j < n && color[l.get(s - 1)] == color[j] && radius[l.get(s - 1)] == radius[j]){
                l.remove(s -1);
                j++;
                s = l.size();
            }
            if(j < n){
                l.add(j);
            }
            j++;

        }
        return l.size();
    }
}
