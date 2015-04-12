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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> vals = new ArrayList<ArrayList<Integer>>();
        if(root==null) return vals;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        int curr_level = 1, next_level=0;
        int level = 0;
        Q.add(root);
        ArrayList<Integer> cur_level_vals = new ArrayList<Integer>();
        while(!Q.isEmpty()){
            TreeNode cur = Q.poll();
            cur_level_vals.add(cur.val);
            curr_level--;
            if(cur.left != null) {
                next_level++;
                Q.add(cur.left);
            }
            if(cur.right != null) {
                next_level++;
                Q.add(cur.right);
            }
            if(curr_level==0){
                curr_level = next_level;
                next_level = 0;
                if(level % 2 == 1){
                    Collections.reverse(cur_level_vals);
                }
                vals.add(new ArrayList<Integer>(cur_level_vals));
                level++;
                cur_level_vals.clear();
            }
        }
        return vals;
    }
}

