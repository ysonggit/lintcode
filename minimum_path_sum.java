public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        int D[][] = new int [m][n];
        D[0][0] = grid[0][0];
        for(int i=1; i<m; i++){
            D[i][0] = grid[i][0] + D[i-1][0];
        }
        for(int j=1; j<n; j++){
            D[0][j] = grid[0][j] + D[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                D[i][j] = Math.min(D[i-1][j], D[i][j-1])+grid[i][j];
            }
        }
        return D[m-1][n-1];
    }
}

