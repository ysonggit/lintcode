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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     * ASSUME THE BST IS VALID
     * 1.Node to be deleted is leaf: Simply remove from the tree.
     * 2.Node to be deleted has only one child: Copy the child to the node and delete the child
     * 3.Node to be deleted has two children: 
     *      Find inorder successor of the node. // minimum node in right subtree
     *      Copy contents of the inorder successor to the node and delete the inorder successor. 
     *      Note that inorder predecessor can also be used.
     */
    public TreeNode getNode(TreeNode root, int value){
        if(root==null) return null;
        if(root.val == value) return root;
        if(root.val > value) return getNode(root.left, value);
        return getNode(root.right, value);
    }
    public TreeNode getInorderSuccessor(TreeNode right_root){
        TreeNode cur = right_root;
        while(cur.left!= null) cur = cur.left;
        return cur;
    }
    public void nullInorderSuccessor(TreeNode right_root){
        TreeNode cur = right_root;
        while(cur.left!= null) {
            if(cur.left.left !=null) cur = cur.left; 
            else {
                cur.left = null;
            }
        }
       
    }
    public TreeNode removeNode(TreeNode root, int value) {
        if(root == null) return null;
        // find the position of the node with given value
        TreeNode to_del = getNode(root, value);
        if(to_del == null) return root;
        // if is leaf
        if(to_del.left == null && to_del.right == null) {
            // corner case: one node tree 
            if(to_del == root) {
                to_del = null;
                return null;
            }else{
                to_del = null;
                return root;
            }
        }else if(to_del.left == null || to_del.right == null){
            // has one child
            TreeNode child;
            if(to_del.left != null){
                // left child only
                child = to_del.left;
            }else{
                // right child only
                child = to_del.right;
            }
            to_del.val = child.val;
            to_del.left = child.left;
            to_del.right = child.right;
            child = null;
            return root;
        }else{
            // has two children
            // find the inorder successor
            TreeNode successor = getInorderSuccessor(to_del.right);
            // cp successor's content to this node
            to_del.val = successor.val;
            nullInorderSuccessor(to_del.right); // mistake : successor = null does not work
        }
        return root;
    }
}

