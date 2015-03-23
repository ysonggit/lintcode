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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        if(root == null ) return vals;
        Stack<TreeNode> parents = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!parents.empty() || cur != null){
            if(cur != null){
                parents.push(cur);
                cur = cur.left;
            }else{
                cur = parents.pop();
                vals.add(cur.val);
                cur = cur.right;
            }
        }
        return vals;
    }
}
