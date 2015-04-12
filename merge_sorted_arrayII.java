class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     * be careful of index (out range check)
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if(n==0) return;
        int i = m-1; 
        int j = n-1;
        int k = m+n-1;
        while(i>=0 || j>=0){
            if(i>=0 && j>=0) {
                if(A[i]<B[j]){
                    A[k] = B[j];
                    j--;
                }else{
                    A[k] = A[i];
                    i--;
                }
            }else{
                if(j<0) break;
                if(i<0) {
                    A[k] = B[j];
                    j--;
                }
            }
            k--;
        }
    }
}

