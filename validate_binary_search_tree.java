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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode cur = root;
        ArrayList<Integer> vals = new ArrayList<Integer>();
        while(!parentStack.empty() || cur!=null){
            if(cur!=null){
                parentStack.push(cur);
                cur = cur.left;
            }else{
                cur = parentStack.pop();
                vals.add(cur.val);
                cur = cur.right;
            }
        }
        for(int i=1; i<vals.size(); i++){
            if(vals.get(i) <= vals.get(i-1)) return false;
        }
        return true;
    }
}

