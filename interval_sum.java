/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    class SegmentTreeNode{
        public int start, end;
        public long sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int[] A) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            // assume inputs are legal
            for(int i=start; i<=end; i++){
                this.sum += A[i];
            }
            this.left = this.right = null;
        }
    }
    
    public SegmentTreeNode build(int start, int end, int[] A){
        if(start>end) return null;
        SegmentTreeNode n = new SegmentTreeNode(start, end, A);
        if(start==end) return n;
        n.left = build(start, (start+end)/2, A);
        n.right = build((start+end)/2+1, end, A);
        return n;
    }
    
    public long query(SegmentTreeNode root, int start, int end){
        if(root==null) return 0;
        if(start>end || start>root.end || end<root.start) return 0;
        if(start<=root.start && end>=root.end) return root.sum;
        return query(root.left, start, end) + query(root.right, start, end);
    }
    
    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
        int n = A.length;
        ArrayList<Long> res = new ArrayList<Long>();
        if (n==0) return res;
        SegmentTreeNode treeroot = build(0, n-1, A);
        for(Interval i : queries){
            res.add(query(treeroot, i.start, i.end));
        }
        return res;
    }
}
