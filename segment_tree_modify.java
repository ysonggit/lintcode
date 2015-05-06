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
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public int query(SegmentTreeNode root, int start, int end){
        if(root==null) return Integer.MIN_VALUE;
        // out of range query
        if(start>end|| start > root.end || end < root.start) return Integer.MIN_VALUE;
        if(start<=root.start && end >= root.end ) return root.max;
        int leftmax = query(root.left, start, end);
        int rightmax = query(root.right, start, end);
        return Math.max(leftmax, rightmax);
    }
    public void modify(SegmentTreeNode root, int index, int value) {
        if(root==null) return;
        // assume index is between [root.start, root.end]
        // otherwise, need to insert new node into tree
        if(index==root.start && index==root.end) {
            root.max = value;
            return;
        }
        // bottom-up procedure
        // see which side should be modified
        int mid = root.start + (root.end-root.start)/2;
        if(index <= mid){
            // modify left
            modify(root.left, index, value);
        }else{
            // modify right
            modify(root.right, index, value);
        }
        // do segment tree query
        int newleftmax = query(root.left, root.left.start, root.left.end);
        int newrightmax = query(root.right, root.right.start, root.right.end);
        root.max = Math.max(newleftmax, newrightmax);
    }
}

