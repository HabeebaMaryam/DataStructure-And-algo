package Leetcode;
import java.util.*;
public class APR15 {
    public static long goodTriplets(int[] nums1, int[] nums2) {
        HashMap<Integer , Integer> map1 = new HashMap<>();
        HashMap<Integer , Integer> map2 = new HashMap<>();
        func(nums1 , 0 , new ArrayList<>() , map1);
        func(nums2 , 0 , new ArrayList<>() , map2);
        long ans = 0;

        for(Integer it : map1.keySet()){
            if(map2.containsKey(it)){
                ans += Math.min(map1.get(it) , map2.get(it));
            }
        }
        return ans;
    }
    public static void func(int[] nums , int ind , ArrayList<Integer> ans , HashMap<Integer , Integer> map){
        if(ind == nums.length)return;
        if(ans.size() == 3){
            int tmp = 0;
            tmp = (ans.get(0) * 100) + (ans.get(1) * 10) + ans.get(2);
            if(map.containsKey(tmp)){
                map.put(tmp , map.get(tmp)+1);
            }
            else{
                map.put(tmp , 1);
            }
            return;
        }
        ans.add(nums[ind]);
        func(nums , ind+1 , ans , map);
        ans.remove(ans.size() - 1);
        func(nums , ind+1 , ans , map);

    }

    public static void main(String[] args) {
        int[] nums1 = {2,0,1,3};
        int[] nums2 = {0,1,2,3};
        System.out.println(goodTriplets(nums1 , nums2));;
    }
}
