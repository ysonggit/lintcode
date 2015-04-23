public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     * combine search in sorted array and minium of rotated array
     * 1. find the position of pivot
     * 2. binary search two sub arrays divided by this pivot
     */
    int findMin(int[] A){
        int n = A.length;
        int front =0, back=n-1;
        while(front<=back){
            if(front==back) return front;
            if(back-front==1){
                int pivot=Math.min(A[front], A[back]);
                return (pivot==A[front]) ? front : back;
            }
            int mid = (front+back)/2;
            if(mid<back && A[mid]>A[mid+1]) return mid+1;
            if(mid>front && A[mid-1]>A[mid]) return mid;
            if(A[mid] >A[back]){
                front=mid+1;
            }else if(A[mid]<A[back]){
                back=mid-1;
            }else{
                back--;
            }
        }
        return 0;
    }
    
    int binarySearch(int[] A, int target, int low, int high){
        if(low>high) return -1;
        int mid = (low+high)/2;
        if(A[mid]==target) return mid;
        if(A[mid]<target) return binarySearch(A, target, mid+1, high);
        return binarySearch(A, target, low, mid-1);
    }
     
    public boolean search(int[] A, int target) {
        int n = A.length;
        if(n==0) return false;
        int pivot_idx = findMin(A);
        int left_idx = binarySearch(A, target, 0, pivot_idx-1);
        if(left_idx>=0) return true;
        int right_idx = binarySearch(A, target, pivot_idx, n-1);
        if(right_idx>=0) return true;
        return false;
    }

}

