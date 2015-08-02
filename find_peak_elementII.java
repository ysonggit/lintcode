class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public int binarySearch(int[] A, int low, int high){
        if(low > high) return -1;
        int n = A.length;
        int mid = (low+high)/2;
        int left = mid-1;
        int right = mid+1;
        if(left<0 || right==n) return -1;
        if(A[mid] > A[left] && A[mid] > A[right] ) return mid;
        if(A[mid] < A[left]) return binarySearch(A, left, mid-1); // mistake: upper bound should not be mid
        if(A[mid] < A[right]) return binarySearch(A, mid+1, right); // mistake: lower bound should be mid (infinite loop!)
        return -1;
    }
    public List<Integer> findPeakII(int[][] A) {
        int n = A.length; // n by m matrix
        List<Integer> peak = new ArrayList<Integer>();
        if(n==0) return peak;
        int m = A[0].length;
        for(int i=1; i<n-1; i++){
            int [] cur_row = A[i];
            int local_peak_col_idx = binarySearch(cur_row, 0, m-1);
            if(local_peak_col_idx > 0){
                int local_peak = A[i][local_peak_col_idx];
                int up = A[i-1][local_peak_col_idx];
                int down = A[i+1][local_peak_col_idx];
                if(local_peak > up && local_peak > down) {
                    peak.add(i);
                    peak.add(local_peak_col_idx);
                    return peak;
                }
            } 
        }
        return peak;
    }
}
