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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        if(root==null) return vals;
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!parentStack.empty()|| cur!= null){
            if(cur!=null){
                vals.add(cur.val);
                if(cur.right != null) parentStack.push(cur.right);
                cur = cur.left;
            }else{
                cur = parentStack.pop();
            }
        }
        return vals;
    }
}
