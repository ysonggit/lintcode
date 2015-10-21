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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        // 1. backup right child
        TreeNode right_cp = root.right;
        // 2. connect flattened left subtree to right  
        root.right = root.left;
        // 3. set left null
        root.left = null;
        // 4. connect right_cp to the tail of right list
        while(root.right!=null) root = root.right;
        root.right = right_cp;
    }
}
