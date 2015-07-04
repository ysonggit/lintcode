public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public void dfs(boolean[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m) return;
        if(!grid[i][j])  return;
        grid[i][j] = false;
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
    public int numIslands(boolean[][] grid) {
        int n = grid.length;
        int count = 0;
        if(n==0) return count;
        int m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
