class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    boolean duplicate(boolean[] existed, char cur){
        if(cur == '.') return false;
        int num = (int) (cur - '1');
        if(existed[num]) return true;
        existed[num] = true;
        return false;
    }
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        if(n==0) return true;
        // check each row
        boolean existed[] = new boolean[n];
        for (int i=0; i<n; i++){
            Arrays.fill(existed, false);
            for(int j=0; j<n; j++){
                char cur = board[i][j];
                if(duplicate(existed, cur)) return false;
            }
        }
        for(int j=0; j<n; j++){
            Arrays.fill(existed, false);
            for(int i=0; i<n; i++){
                char cur = board[i][j];
                if(duplicate(existed, cur)) return false;
            }
        }
        for(int i=0; i<n; i+=3){
            for(int j=0; j<n; j+=3){
                Arrays.fill(existed, false);
                for(int k=0; k<n; k++){
                    char cur = board[i+k/3][j+k%3];
                    if(duplicate(existed, cur)) return false;
                }
            }
        }
        return true;
    }
};

