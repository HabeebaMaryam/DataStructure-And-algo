package Trie;

public class Implimentation2 {
    static class Trie {
        Trie[] trie = new Trie[26];
        int end_count = 0;
        int prefix_count = 0;

        Trie(){}
        public boolean containsKey(char ch){
            return trie[ch - 'a'] != null;
        }
        public Trie get( char ch){
            return trie[ch - 'a'];
        }
        public void put(char ch ){
            trie[ch - 'a'] = new Trie();

        }

        public void insert(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch);
                }
                node = node.get(ch);
                node.prefix_count++;
            }
            node.end_count++;
        }

        public int startCount(String start_word){
            Trie node = this;
            for(int i = 0; i < start_word.length(); i++){
                char ch = start_word.charAt(i);
                if(!node.containsKey(ch)){
                    return 0;
                }
                node = node.get(ch);
            }
            return node.prefix_count;
        }

        public int endWithCount(String end_word){
            Trie node = this;
            for(int i = 0; i < end_word.length(); i++){
                char ch = end_word.charAt(i);
                if(!node.containsKey(ch)){
                    return 0;
                }
                node = node.get(ch);
            }
            return node.end_count;
        }

        public void erase(String word){
            Trie node = this;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);

            }
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("samsung");
        obj.insert("samsung");
        obj.insert("vivo");
        obj.insert("vivo");
        obj.insert("vivo");
        obj.insert("vi");

        System.out.println(obj.startCount("vi"));

    }
}
