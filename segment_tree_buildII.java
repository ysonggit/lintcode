/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode buildRecur(int[] A, int start, int end){
        if(start>end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if(start==end) {
            root.max = A[start];
            return root;
        }
        root.left = buildRecur(A, start, (start+end)/2);
        root.right = buildRecur(A, (start+end)/2+1, end);
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }
    public SegmentTreeNode build(int[] A) {
        return buildRecur(A, 0, A.length-1);
    }
}
