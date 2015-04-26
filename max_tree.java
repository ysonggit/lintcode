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
    void insertRight(TreeNode node, int cur){
        if(node.right == null){
            TreeNode newnode = new TreeNode(cur);
            node.right = newnode;
            return ;
        }
        if(node.right.val < cur){
            // cur will be the new subtree root
            // mistake: must save a copy of node.right
            TreeNode rightcopy = node.right;
            TreeNode subroot = new TreeNode(cur);
            node.right = subroot;
            subroot.left = rightcopy;
            return;
        }
        insertRight(node.right, cur);
    }
    public TreeNode maxTree(int[] A) {
        int n = A.length;
        if(n==0) return null;
        TreeNode root = new TreeNode(A[0]);
        for(int i=1; i<n; i++){
            int cur = A[i];
            if(cur > root.val){
                TreeNode newroot = new TreeNode(cur);
                newroot.left = root;
                root = newroot;
            }else{
                insertRight(root, cur);
            }
        }
        return root;
    }
}

