/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode build(int[] A, int low, int high){
        if(low>high) return null;
        int mid = (low+high)/2;
        TreeNode n = new TreeNode(A[mid]);
        n.left = build(A, low, mid-1);
        n.right = build(A, mid+1, high);
        return n;
    } 
     
    public TreeNode sortedArrayToBST(int[] A) {  
        int n = A.length;
        if(n==0) return null;
        TreeNode root = build(A, 0, n-1);
        return root;
    }  
}

