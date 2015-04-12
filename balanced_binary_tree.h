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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public int getHeight(TreeNode node){
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right))+1;
    }
     
    public boolean isBalanced(TreeNode root) {
        if(root== null) return true;
        int diff = Math.abs(getHeight(root.left) - getHeight(root.right)) ;
        if(diff>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
