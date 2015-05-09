public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     * binary search and similar to 3 sum closet
     */
     
    public int binarySearch(int[]B, int target){
        int low = 0, high = B.length-1;
        int local_min_diff = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(B[mid]==target) return 0;
            local_min_diff= Math.min(local_min_diff, Math.abs(B[mid]-target));
            if(B[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return local_min_diff;
    }
    public int smallestDifference(int[] A, int[] B) {
        int n = A.length, m = B.length;
        if(n==0 || m==0) return -1;
        Arrays.sort(A);
        Arrays.sort(B);
        int min_diff = Integer.MAX_VALUE;
        for(int i : A){
            min_diff = Math.min(min_diff, binarySearch(B, i));
            if(min_diff==0) return 0;
        }
        return min_diff;
    }
}


