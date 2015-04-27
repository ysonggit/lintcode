class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     * Representations:
     * queens[i] = j means there is a queen placed at row i, col j
     * arranged_cols[k] = true means the k column is placed with a queen
     * 
     * every time, in a column c without a queen (arranged_cols[c]==false )
     * iterate row 0 to n-1, check if there is available position 
     */
    int total = 0;
    boolean ok(int[] queens, boolean [] arranged_cols, int cur_row, int cur_col){
        // NO need to check row, since we always move to next row
        // same column ?
        if(arranged_cols[cur_col]) return false;
        // Among previous rows, check diagnoal 
        for(int i=0; i<cur_row; i++){
            int j = queens[i];
            if(j>=0){
                if(cur_row-i == Math.abs(cur_col-j)) return false;
            }
        }
        return true;
    }
    
    void dfs(int[] queens, boolean [] arranged_cols, int cur_row){
        int n = queens.length;
        if(cur_row == n){
            total +=1;
            return;
        }
        for(int j=0; j<n; j++){
            // if cur_row, j is ok to place a queen
            // update queens and arranged_cols, check next row
            if(ok(queens, arranged_cols, cur_row, j)){
                queens[cur_row] = j;
                arranged_cols[j] = true;
                dfs(queens, arranged_cols, cur_row+1);
                queens[cur_row] = -1;
                arranged_cols[j] = false;
            }
        }
    }
     
    public int totalNQueens(int n) {
        if(n==0) return 0;
        int queens[] = new int[n];
        for(int i : queens) i = -1;
        boolean arranged_cols[] = new boolean[n];
        dfs(queens, arranged_cols, 0);
        return total;
    }
};


