public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m==0) return 0;
        int n = obstacleGrid[0].length;
        int P[][] = new int[m][n];
        P[0][0] = (obstacleGrid[0][0]==1) ? 0 : 1;
        for(int k=1; k<m; k++){
            P[k][0] = (obstacleGrid[k][0]==1 || P[k-1][0]==0) ? 0 : 1;
        }
        for(int k=1; k<n; k++){
            P[0][k] = (obstacleGrid[0][k]==1 || P[0][k-1]==0) ? 0 : 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    P[i][j] = 0;
                }else{
                    P[i][j] = P[i-1][j] + P[i][j-1];
                }
            }
        }
        return P[m-1][n-1];
    }
}
