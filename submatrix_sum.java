public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     * assume solution always exits
     */
    public void getCoordinate(int [][] M, int leftrow, int leftcol, int rightrow, int rightcol){
        M[0][0] = leftrow;
        M[0][1] = leftcol;
        M[1][0] = rightrow;
        M[1][1] = rightcol;
    } 
    public int[][] submatrixSum(int[][] matrix) {
        int M[][] = new int [2][2];
        int m = matrix.length;
        int n = matrix[0].length;
        int target = 0;
        int compressed_row [] = new int[n];
        for(int toprow=0; toprow<m; toprow++){
            for(int bottomrow=toprow; bottomrow<m; bottomrow++){
                Arrays.fill(compressed_row, 0);
                for(int col=0; col<n; col++){
                    for(int row=toprow; row<=bottomrow; row++){
                        compressed_row[col] += matrix[row][col];
                    }
                }
                for(int i=0; i<n; i++){
                    int sum = compressed_row[i];
                    if(sum == target) {
                        getCoordinate(M, toprow, i, bottomrow, i);
                        return M;
                    }
                    for(int j=i+1; j<n; j++){
                        sum += compressed_row[j];
                        if(sum==target){
                            getCoordinate(M, toprow, i, bottomrow, j);
                            return M;
                        }
                    }
                }
            }
        }
        return M;
    }
}
