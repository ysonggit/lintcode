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
    class SegmentTreeNode {
        public int start, end, min;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.min = Integer.MAX_VALUE;
            left = right = null;
        }
    }
    
    public SegmentTreeNode build(int start, int end, int []A){
        if(start>end) return null;
        SegmentTreeNode n = new SegmentTreeNode(start, end);
        if(start == end) {
            n.min = A[start];
            return n;
        }
        n.left = build(start,(start + end)/2, A);
        n.right = build((start+end)/2+1, end, A);
        n.min = Math.min(n.left.min, n.right.min);
        return n;
    }
    
    public int query(SegmentTreeNode root, int start, int end){
        if(root == null) return Integer.MAX_VALUE;
        if(start>end || start > root.end || end < root.start) return Integer.MAX_VALUE;
        if(start <= root.start && end >= root.end) return root.min;
        return Math.min(query(root.left, start, end), query(root.right, start, end));
    }
    
    public ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
        int n = A.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n==0) return res;
        SegmentTreeNode treeroot = build(0, n-1, A);
        for(Interval i : queries){
            res.add(query(treeroot, i.start, i.end));
        }
        return res;
    }
}

