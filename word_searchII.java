public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    class TrieNode{
        Character letter; 
        boolean is_word;
        HashMap<Character, TrieNode> children;    
        TrieNode(){
            letter=null;
            is_word = false;
            children = new HashMap<Character, TrieNode>();
        }
        TrieNode(char c){
            letter=new Character(c);
            is_word=false;
            children = new HashMap<Character, TrieNode>();
        }
    }
    
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new TrieNode(c));
                }
                cur = cur.children.get(c);
            }
            cur.is_word = true;
        }
        public boolean find(String word){
            TrieNode cur= root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(!cur.children.containsKey(c)) return false;
                cur = cur.children.get(c);
            }
            return cur.is_word;
        }
    }
    
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    
    public void dfs(char[][] board, ArrayList<String> res, TrieNode root, int i, int j, StringBuilder path){
        if(i<0||i==board.length || j<0 || j== board[0].length) return;
        if(root.is_word){
            String wd = path.toString();
            if(!res.contains(wd)) res.add(wd); // mistake : duplicates could be found
           // return; // mistake should not return. Example matrx contains see and dict contains se see 
        }
        char c = board[i][j];
        if(root.children.containsKey(c)){
            path.append(c);
            for(int k=0; k<4; k++){
                board[i][j] = 0;   // trick to mark visited on the fly
                dfs(board, res, root.children.get(c), i+dx[k],j+dy[k], path);
                board[i][j] = c;
            }
            path.deleteCharAt(path.length()-1);
        }
    }
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> res = new ArrayList<String>();
        int n = board.length;
        if(n==0 || words.size()==0) return res;
        int m = board[0].length;
        Trie dict = new Trie();
        for(String wd : words){
            dict.insert(wd);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                StringBuilder path = new StringBuilder();
                dfs(board, res, dict.root,  i, j, path);
            }
        }
      
        return res;
    }
}

