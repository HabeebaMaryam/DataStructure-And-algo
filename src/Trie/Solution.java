package Trie;
import java.util.* ;
import java.io.*;

class Solution {
    static class Trie{
        Trie[] trie = new Trie[26];
        boolean flag = false;

        Trie(){}

        public boolean conrainsKey(char ch ){
            return trie[ch - 'a'] != null;
        }
        public void put(char ch){
            trie[ch - 'a'] = new Trie();
        }
        public Trie get(char ch){
            return trie[ch - 'a'];
        }
        public void setEnd(){
            flag = true;
        }
        public boolean isEnd(){
            return flag;
        }

        public void insert(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.conrainsKey(ch)){
                    node.put(ch);
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
    }
    public static boolean checkComplete(String s , Trie root){
        Trie node = root;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!node.get(ch).isEnd()){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
    public static String completeString(int n, String[] a) {
        // Write your code here.
        Trie obj = new Trie();
        for(int i = 0; i < n; i++){
            obj.insert(a[i]);
        }
        String ans = "";
        int len = 0;
        for(int i = 0; i < n; i++){
            if(checkComplete(a[i] , obj)){
                if(ans.equals("")){
                    ans = a[i];
                }
                if(a[i].length() >= len){
                    len = a[i].length();

                    if(a[i].compareTo(ans) < 0){
                        ans = a[i];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"ab" , "abc" , "a" , "bp"};
        System.out.println(completeString(s.length,s));
    }
}