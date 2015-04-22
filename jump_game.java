public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        int n = A.length;
        if(n==0) return false;
        int max_reachable_pos = A[0];
        for(int i=1; i<n; i++){
            if(max_reachable_pos < i) return false;
            max_reachable_pos = Math.max(max_reachable_pos, i+A[i]);
            if(max_reachable_pos >= n-1) return true;
        }
        return (A[0] <0 ) ? false : true; // [1] -> true; [0]-> true
    }
}
