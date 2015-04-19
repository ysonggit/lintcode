public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void zeroCol(int[][] matrix, int col){
        int m = matrix.length;
        for(int i=0; i<m; i++){
            matrix[i][col] = 0;
        }
    }
    public void zeroRow(int[][] matrix, int row){
        int n = matrix[row].length;
        for(int i=0; i<n; i++){
            matrix[row][i] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return;
        int n = matrix[0].length;
        // check first line if contains zeros
        boolean zero_first_row = false;
        for(int k : matrix[0]){
            if(k==0) zero_first_row = true;
        }
        boolean zero_first_col = false;
        for(int i=0; i<m; i++){
            if(matrix[i][0]==0) zero_first_col = true;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0 ){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // check col
        for(int i=1; i<n; i++){
            if(matrix[0][i]==0) zeroCol(matrix, i);
        }
        // check row 
        for(int i=1; i<m; i++){
            if(matrix[i][0]==0) zeroRow(matrix, i);
        }
        
        if(zero_first_row) zeroRow(matrix, 0);
        if(zero_first_col) zeroCol(matrix, 0);
    }
}
