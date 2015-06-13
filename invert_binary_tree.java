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
     * iterative version
     */
    public void invertBinaryTree(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.empty()){
            TreeNode cur = s.pop();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if(cur.left != null) s.push(cur.left);
            if(cur.right != null) s.push(cur.right);
        }
        
    }
}
