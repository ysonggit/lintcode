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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        if(root == null) return vals;
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!parentStack.isEmpty() || cur != null){
            if(cur!= null){
                parentStack.push(cur);
                cur = cur.left;
            }else{
                cur = parentStack.pop();
                if(cur.val>=k1 && cur.val <= k2){
                    vals.add(cur.val);
                }
                cur = cur.right;
            }
        }
        return vals;
    }
}

