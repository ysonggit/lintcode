public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    // search insertion position
    public int binarySearch(int[] A, int target){
        int n = A.length;
        if(n==0) return 0; 
        int left =0, right = n-1;
        while(left<=right){ // mistake : <= 
            int mid=(right-left)/2 + left;
            if(A[mid]==target){
                while(mid>0 && A[mid-1]==target) mid--; // fuck Duplicates!!!
                return mid;
            }else if(A[mid]<target){
                left=mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
    
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        int n = A.length;
        int m = queries.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if( m==0) return res; // mistake : n==0 , should not return [], instead return [0]
        Arrays.sort(A);
        for(int i=0; i<m; i++){
            int pos = binarySearch(A, queries[i]); // refer search insertion position
            if(pos<0) {
                res.add(0);
            }else{
                res.add(pos);
            }
        }
        return res;
    }
}

