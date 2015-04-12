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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer> > allvals = new ArrayList<ArrayList<Integer> >();
        if(root==null) return allvals;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curr_level = 1;
        int next_level = 0;
        ArrayList<Integer> curr_vals = new ArrayList<Integer>();
        while(queue.size()!=0){
            TreeNode cur = queue.poll();
            curr_level--;
            curr_vals.add(cur.val);
            if(cur.left != null) {
                next_level++;
                queue.add(cur.left);
            }
            if(cur.right != null){
                next_level++;
                queue.add(cur.right);
            }
            if(curr_level==0){
                allvals.add(new ArrayList<Integer>(curr_vals));
                curr_level = next_level;
                next_level = 0;
                curr_vals.clear();
            }
        }
        return allvals;
    }
}
