/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // special case
        if(start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if(start == end) return root;
        Queue<SegmentTreeNode> Q = new LinkedList<SegmentTreeNode>();
        Q.add(root);
        while(!Q.isEmpty()){
            SegmentTreeNode cur = Q.poll();
            if(cur.start != cur.end){
                SegmentTreeNode left = new SegmentTreeNode(cur.start, (cur.start+cur.end)/2);
                cur.left = left;
                SegmentTreeNode right = new SegmentTreeNode((cur.start+cur.end)/2+1, cur.end);
                cur.right = right;
                Q.add(cur.left);
                Q.add(cur.right);
            }
        }
        return root;
    }
}

