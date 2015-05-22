public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        int n = A.length;
        if(n==0) return 0;
        if(n==1) return A[0];
        long max_2=0, max_1=A[0], max_cur=0;
        for(int i=1; i<n; i++){
            max_cur = Math.max(max_2+A[i], max_1);
            max_2 = max_1;
            max_1 = max_cur;
        }
        return max_cur;
    }
}

