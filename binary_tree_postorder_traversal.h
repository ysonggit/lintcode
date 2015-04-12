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
     * @return: Postorder in ArrayList which contains node values.
     * Push the root node to the first stack.
     * Pop a node from the first stack, and push it to the second stack.
     * Then push its left child followed by its right child to the first stack.
     * Repeat step 2) and 3) until the first stack is empty.
     * Once done, the second stack would have all the nodes ready to be traversed in post-order. 
     * Pop off the nodes from the second stack one by one and you’re done.
     */
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        if(root==null) return vals;
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> outputStack = new Stack<TreeNode>();
        s.push(root);
        while(!s.empty()){
            TreeNode cur = s.pop();
            outputStack.push(cur);
            if(cur.left!=null) s.push(cur.left);
            if(cur.right!=null) s.push(cur.right);
        }
        while(!outputStack.empty()){
            TreeNode cur = outputStack.pop();
            vals.add(cur.val);
        }
        return vals;
    }
}
