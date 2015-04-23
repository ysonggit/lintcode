public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     * [2 3 1 1 4]
     * max_reachable_idx_by_pre_idx
     *  2 4 4 4 4
     * max_reachable_idx_with_minsteps
     *  0 2 2 4 4
     * minsteps
     *  0 1 1 2 2
     */
    public int jump(int[] A) {
        int n = A.length;
        if(n==0) return 0;
        int minsteps = 0;
        int max_reachable_idx_with_minsteps = 0;
        int max_reachable_idx_by_pre_idx = A[0];
        for(int i=1; i<n; i++){
            // if not reachable, then return a zero
            if(max_reachable_idx_by_pre_idx < i) return 0;
            if(i>max_reachable_idx_with_minsteps){
                minsteps++;
                max_reachable_idx_with_minsteps = max_reachable_idx_by_pre_idx;
            }
            max_reachable_idx_by_pre_idx = Math.max(max_reachable_idx_by_pre_idx, i+A[i]);
            if(max_reachable_idx_with_minsteps >= n-1) return minsteps;
        }
        return minsteps;
    }
}

