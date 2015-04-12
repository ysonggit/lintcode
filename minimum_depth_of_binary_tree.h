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
     * recursive
     */
    /*
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left == null) return minDepth(root.right)+1;
        if(root.right== null) return minDepth(root.left)+1;
            
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }*/
    /** 
     * iterative BFS (level-order)
     * return depth once find the first leaf node
     */
    public boolean isLeaf(TreeNode node){
        if(node==null) return false;
        return (node.left==null && node.right == null);
    }
    public int minDepth(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curr_level = 1;
        int next_level = 0;
        int min_depth = 1;
        while(queue.size()!=0){
            TreeNode n = queue.poll();
            curr_level--;
            if(isLeaf(n)) return min_depth;
            if(n.left != null){
                next_level++;
                queue.add(n.left);
            }
            if(n.right!=null){
                next_level++;
                queue.add(n.right);
            }
            if(curr_level==0){
                min_depth++;
                curr_level = next_level;
                next_level = 0;
            }
        }
        return min_depth;
    } 
}
