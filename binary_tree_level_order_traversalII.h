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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        ArrayList<ArrayList<Integer>> vals = new ArrayList<ArrayList<Integer>>();
        if(root==null) return vals;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int curr_level = 1, next_level = 0;
        ArrayList<Integer> curr_vals = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode cur = q.remove();
            curr_vals.add(cur.val);
            curr_level--;
            if(cur.left != null){
                next_level++;
                q.add(cur.left);
            }
            if(cur.right != null){
                next_level++;
                q.add(cur.right);
            }
            if(curr_level==0){
                curr_level = next_level;
                next_level = 0;
                vals.add(0, new ArrayList<Integer>(curr_vals));
                curr_vals.clear();
            }
        }
        return vals;
    }
}
