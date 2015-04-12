public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        int n = A.length;
        if(n==0) return 0;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(A[mid]==target) return mid;
            if(A[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}


