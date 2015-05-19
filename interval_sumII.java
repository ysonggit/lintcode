public class Solution {
    /* you may need to use some attributes here */
    class SegmentTreeNode{
        int start, end;
        long sum;
        SegmentTreeNode left, right;
        SegmentTreeNode(int start, int end, int[]A){
            this.start = start;
            this.end = end;
            for(int i=start; i<=end; i++){
                sum+= A[i];
            }
            left = right = null;
        }
    }    

    public SegmentTreeNode build(int[] A, int start, int end){
        if(start>end) return null;
        SegmentTreeNode n = new SegmentTreeNode(start, end, A);
        if(start == end) return n;
        n.left = build(A, start, (start+end)/2);
        n.right = build(A, (start+end)/2+1, end);
        return n;
    }
    
    public long query(SegmentTreeNode root, int start, int end){
        if(root==null) return 0;
        if(start > root.end || end<root.start || start>end) return 0;
        if(start<= root.start && end >= root.end) return root.sum;
        return query(root.left, start, end) + query(root.right, start, end);
    }
    
    public void modify(SegmentTreeNode root, int index, int value){
        if(root==null) return;
        if(index == root.start && index == root.end){
            root.sum = value;
            return;
        }
        int mid = (root.start+root.end)/2;
        if(index>mid){
            modify(root.right, index, value);
        }else{
            modify(root.left, index, value);
        }
        long leftsum = query(root.left, root.left.start, root.left.end);
        long rightsum = query(root.right, root.right.start, root.right.end);
        root.sum = leftsum + rightsum;
    }
    
    SegmentTreeNode root;
    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        root = build(A, 0, A.length-1);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return query(root, start, end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modify(root, index, value);
    }
}
