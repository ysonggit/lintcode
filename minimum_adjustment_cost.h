public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     * Similar to the backpack problem II
     * Define MinCost[i][j] as the minimal cost of adjust the i-th number to value j
     * MinCost[i][j] = min(MinCost[i-1][k] + |A[i] -j| ) such that |j-k| <= target
     * where k is the adjusted value adjacent to j
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int n = A.size();
        if(n==0) return 0;
        int m = 100; // m means the max number could be adjusted to 
        int [][] MinCost = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(MinCost[i], Integer.MAX_VALUE);
        }
        for(int i=1; i<=n; i++){
            int cur = A.get(i-1);
            for(int j=1; j<=m; j++){
                int cost_from_cur_to_j = Math.abs(cur - j);
                // determine the range of the adjacent adjusted value
                int lower = (j - target >0)? j-target : 1;
                int upper = (j + target >m)? m : j + target;
                for(int k = lower; k<= upper; k++){
                    MinCost[i][j] = Math.min(MinCost[i][j], MinCost[i-1][k]+cost_from_cur_to_j);
                }
            }
        }
        int global_min = MinCost[n][m];
        for(int i=m-1; i>0; i--){
            global_min = Math.min(global_min, MinCost[n][i]);
        }
        return global_min;
    }
}
