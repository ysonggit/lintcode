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
     * @return: An integer.
     * localmax of current node = max of
     *                   current node value, 
     *                   current node value + localmax of leftsubtree,
     *                   current node value + localmax of rightsubtree
     * globalmax of current node = max of 
     *                   localmax of current node,
     *                   globalmax so far,
     *                   bridge 
     */
    int globalmax;
    public int localMaxSum(TreeNode node){
        if(node==null) return 0;
        int cur = node.val;
        int leftmax = localMaxSum(node.left) + cur;
        int rightmax = localMaxSum(node.right)+cur;
        int localmax = Math.max(cur, Math.max(leftmax, rightmax));
        int bridge = leftmax + rightmax - cur;
        globalmax = Math.max(globalmax, Math.max(localmax, bridge));
        return localmax;
    }
    
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        globalmax = Integer.MIN_VALUE;
        localMaxSum(root);
        return globalmax;
    }
}
