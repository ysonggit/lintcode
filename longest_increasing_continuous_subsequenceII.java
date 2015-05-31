public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int max_len = 1;
    
    public void dfs(int [][]A, int i, int j, boolean [][]visited, int count){
        int m = A.length, n = A[0].length;
        if(i<0 || j<0|| i==m || j==n) return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        max_len = Math.max(max_len, count);
        if(i+1<m && A[i+1][j] > A[i][j]) {
            dfs(A, i+1, j, visited, count+1);
        }
        if(i-1>=0 && A[i-1][j] > A[i][j]){
            dfs(A, i-1, j, visited, count+1);
        }
        if(j+1<n && A[i][j+1] > A[i][j]){
            dfs(A, i, j+1, visited, count+1);
        }
        if(j-1>=0 && A[i][j-1] > A[i][j]){
            dfs(A, i, j-1, visited, count+1);
        }
        visited[i][j]= false;
    }
    
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        int m = A.length;
        if(m==0) return 0;
        int n = A[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean visited[][] = new boolean[m][n];
                dfs(A, i, j, visited, 1);
                if(max_len >= m *n) break;
            }
        }
        return max_len;
    }
}
