public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean dfs(char[][]board, String word, boolean[][] visited, int cur_idx,  
    int i, int j){
        if(i<0 || j<0 || i==board.length || j==board[0].length) return false;
        if(visited[i][j]) return false;
        if(board[i][j] != word.charAt(cur_idx)) return false;
        if(board[i][j]==word.charAt(cur_idx) && cur_idx == word.length()-1) return true;
        visited[i][j]= true;
        boolean find = dfs(board, word, visited, cur_idx+1, i+1, j) || dfs(board, word, visited, cur_idx+1, i, j+1) ||
                       dfs(board, word, visited, cur_idx+1, i-1, j) || dfs(board, word, visited, cur_idx+1, i, j-1);
        visited[i][j]=false;
        return find;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if (n==0) return false;
        int m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean visited[][] = new boolean[n][m];
                if(dfs(board, word, visited, 0, i, j)) return true;
            }
        }
        return false;
    }
}

