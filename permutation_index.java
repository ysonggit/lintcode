public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     * http://stackoverflow.com/questions/12146910/finding-the-lexicographic-index-of-a-permutation-of-a-given-array
     */
    public long factorial(int n){
        if(n<=1) return 1L;
        return 1L * n * factorial(n-1);
    }
    public long permutationIndex(int[] A) {
        int n = A.length;
        if(n==0) return 0;
        long idx = 1L;
        for(int i=0; i<n; i++){
            int cur = A[i];
            int num_lessthan_cur = 0;
            for(int j=i+1; j<n; j++){
                int follower = A[j];
                if(follower < cur) num_lessthan_cur ++;
            }
            idx += num_lessthan_cur * factorial(n-i-1);
        }
        return idx;
    }
}
