public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        int n = A.length;
        if(n==0) return 0;
        int B[][] = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            int cur_size = A[i-1], cur_val = V[i-1];
            for(int j=1; j<=m; j++){
                if(j-cur_size>=0){
                    B[i][j] = Math.max(B[i-1][j], B[i-1][j-cur_size]+cur_val);
                }else{
                    B[i][j] = B[i-1][j];
                }
            }
        }
        int max_val = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                max_val = Math.max(max_val, B[i][j]);
            }
        }
        return max_val;
    }
}
