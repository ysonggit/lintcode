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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    Stack<TreeNode> nodes;
    public Solution(TreeNode root) {
        nodes = new Stack<TreeNode>();
        if(root==null) return ;
        TreeNode cur = root;
        while(cur!=null){
            nodes.push(cur);
            cur = cur.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !nodes.empty();
    }
    
    //@return: return next node
    public TreeNode next() {
        if(nodes.empty()) return null;
        TreeNode to_pop = nodes.peek();
        TreeNode cur = nodes.pop();
        if(cur.right != null){    
            cur = cur.right;
            while(cur!=null){
                nodes.push(cur);
                cur = cur.left;
            }
        }
        return to_pop;
    }
}

