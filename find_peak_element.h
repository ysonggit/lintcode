class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if(A.length<3) return -1;
        int n = A.length;
        int start = 0, end = n - 1;
        while(start< end){
            int mid = (start+ end)/2;
            int left = mid - 1;
            int right = mid + 1;
            if(left >=0 && right<n){
                if(left == 0 && A[mid] > A[right] ) return mid;
                if(right == n -1 && A[mid] > A[left]) return mid;
                if(A[mid] > A[left] && A[mid] > A[right]) return mid;
                if(A[mid] < A[left]) {
                    end = mid;
                    continue;
                }
                if(A[mid] < A[right]){
                    start = mid;
                    continue;
                }
            }
        }
        return -1;
    }
}

