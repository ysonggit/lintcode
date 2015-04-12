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
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if(root==null) return Integer.MIN_VALUE;
        if(start>end || start>root.end || end < root.start) return Integer.MIN_VALUE;
        // start<= [root.start, root.end] <= end
        if(start<= root.start && end>=root.end) return root.max;
        int leftmax = query(root.left, start, end);
        int rightmax = query(root.right, start, end);
        return Math.max(leftmax, rightmax);
    }
}

