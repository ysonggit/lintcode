public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     * contains duplicates ?
     * idea: hashmap, key is pos, value is A[pos]
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        int n = A.length;
        if(n<2) return n;
        int count_increase = 1, count_decrease = 1;
        int max_increase =1, max_decrease = 1;
        for(int i=1; i<n; i++){
            if(A[i]>A[i-1]){
                count_increase++;
                count_decrease = 1;
            }else{
                count_decrease++;
                count_increase = 1;
            }
            max_decrease = Math.max(max_decrease, count_decrease);
            max_increase = Math.max(max_increase, count_increase);
        }
        return Math.max(max_increase, max_decrease);
    }
}

