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
    Queue<TreeNode> successors;
    public Solution(TreeNode root) {
        successors = new LinkedList<TreeNode>();
        if(root != null){
            Stack<TreeNode> parentStack = new Stack<TreeNode>();
            TreeNode cur = root;
            while(!parentStack.empty()||cur!= null){
                if(cur!= null){
                    parentStack.push(cur);
                    cur = cur.left;
                }else{
                    cur = parentStack.pop();
                    successors.offer(cur);
                    cur = cur.right;
                }
            }
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !successors.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        return successors.poll();
    }
}

