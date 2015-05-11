/*public class Solution {
    // Error-prone many corner cases!
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
}*/

public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     * Using segment tree I prefer this solution
     */
    class SegmentTreeNode{
        int start, end, count;
        SegmentTreeNode left, right;
        SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            left = right = null;
        }
    }
    
    public SegmentTreeNode build(int low, int high){
        if(low>high) return null;
        SegmentTreeNode root = new SegmentTreeNode(low, high);
        if(low==high) return root;
        int mid = (low+high)/2;
        root.left = build(low, mid);
        root.right = build(mid+1, high);
        return root;
    }
    // return the count of numbers smaller than the target in array A
    public int query(int [] A, SegmentTreeNode root, int target){
        if(root==null) return 0;
        if(target<=A[root.start]) return root.start;
        if(target>A[root.end]) {
          return root.end;
        }
        int mid = (root.start + root.end)/2;
        if(target <= A[mid]) return query(A, root.left, target);
        return query(A, root.right, target);
    }
    
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        if(queries.length==0) return res;
        Arrays.sort(A);
        SegmentTreeNode treeroot = build(0, n-1);
        for(int i: queries){
            res.add(query(A, treeroot, i));
        }
        return res;
    }
}

