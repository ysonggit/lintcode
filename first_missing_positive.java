public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        if(n==0) return 1;
        for(int i=0; i<n; i++){
            while(A[i]!= i+1){// mistake : used if. should keep on swapping until current i satisfies A[i]=i+1
                if(A[i]-1<0 || A[i]-1>=n || A[i]==A[A[i]-1] ) break; 
                int j = A[i]-1;
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
            }
        }
        for(int i=0; i<n; i++){
            if(A[i]!=i+1) return i+1;
        }
        return n+1; // [1 2 3] should return 4
    }
}
