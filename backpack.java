public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int n= A.length;
        if(n==0) return 0;
        boolean B[][] = new boolean[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            Arrays.fill(B[i], false);
        }
        B[0][0] = true;
        for(int i=1; i<=n; i++){
            int cur_weight = A[i-1];
            for(int j=0; j<=m; j++){
                if(j-cur_weight>=0 && B[i-1][j-cur_weight]){
                    B[i][j] = true;
                }else{
                    B[i][j] = B[i-1][j];
                }
            }
        }
        int max_weight = 0;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(B[i][j]) max_weight = Math.max(max_weight, j);
            }
        }
        return max_weight;
        
    }
}

