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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     * recursive
     
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root==null) return node;
        if(node.val < root.val){
            root.left= insertNode(root.left, node);
        }else{
            root.right = insertNode(root.right, node);
        }
        return root;
    }*/
    /** 
     * iterative 
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root==null) return node;
        TreeNode parent = root;
        while(parent != null){
            if(node.val < parent.val){
                if(parent.left == null){ 
                    parent.left = node;
                    break;   
                }else{
                    parent = parent.left;
                }
            }else{
                if(parent.right==null){
                    parent.right = node;
                    break;   
                }else{
                    parent = parent.right;
                }
            }
        }
        return root;
    }
}
