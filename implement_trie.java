/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children;
    boolean is_word;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        is_word = false;
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                TrieNode child = new TrieNode();
                cur.children.put(c, child);
            }
            cur = cur.children.get(c);
        }
        cur.is_word = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return cur.is_word;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur =root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return true;
    }
}
