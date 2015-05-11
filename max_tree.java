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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode insert(TreeNode root, int cur){
        TreeNode node = new TreeNode(cur);
        if(root==null) {
            return node;
        }
        if(node.val>root.val){
            node.left = root;
            return node;
        }
        // keep on looking up the subtree of root 
        root.right = insert(root.right, cur);    
        return root;
    }
    public TreeNode maxTree(int[] A) {
        int n = A.length;
        if(n==0) return null;
        TreeNode root = new TreeNode(A[0]);
        for(int i=1; i<n; i++){
            int cur = A[i];
            if(cur > root.val){
                TreeNode node = new TreeNode(cur);
                node.left = root;
                root = node;
            }else{
                root.right = insert(root.right, cur);
            }
        }
        return root;
    }
}
