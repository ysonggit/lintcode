public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public boolean isSquare(int[][] matrix, int row, int col, int len){
        int n = matrix.length;
        int m = matrix[0].length;
        if(row+len>n || col+len>m) return false;
        for(int i=row; i<row+len; i++){
            for(int j=col; j<col+len; j++){
                if(matrix[i][j]==0) return false;
            }
        }
        return true;
    }
    public int maxSquare(int[][] matrix) {
        int n = matrix.length;
        int max_area = 0;
        if(n==0) return 0;
        int m = matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int len=1; len<=Math.min(n-i, m-j); len++){
                    if(isSquare(matrix, i, j, len)){
                        max_area = Math.max(max_area, len*len);
                    }
                }
            }
        }
        return max_area;
    }
}
