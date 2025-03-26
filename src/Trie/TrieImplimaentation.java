package Trie;

class Trie{
    private Trie[] trie = new Trie[26];
    private boolean flag = false;

    Trie(){}

    public boolean containsKey(char ch){
        return trie[ch - 'a'] != null;
    }

    public void put(char ch){
        this.trie[ch - 'a'] = new Trie();
    }

    public Trie get(char ch ){
        return this.trie[ch - 'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }

    public void insert(String word , Trie root){
        Trie node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean searchWord(String word , Trie root){
        Trie node = root;

        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean isStartsWith(String word , Trie root){
        Trie node = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch) ){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

}

public class TrieImplimaentation {
    public static void main(String[] args) {
        Trie root = new Trie();
        root.insert("apple" , root);
        root.insert("apps" , root);
        root.insert("apxl" , root);
        root.insert("bac" , root);
        root.insert("bat" , root);

        System.out.println(root.searchWord("appe", root));
        System.out.println(root.isStartsWith("apl", root));

    }
}
