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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean sameSubtree(TreeNode T1, TreeNode T2){
        if(T1==null && T2==null) return true;
        if(T1==null || T2==null) return false;
        if(T1.val != T2.val) return false;
        return sameSubtree(T1.left, T2.left) && sameSubtree(T1.right, T2.right);
    }
    
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if(T2==null) return true;
        //if(T2!=null && T1==null) return false;
        boolean found = false;
        if(T1 !=null && T2 != null){
            if(T1.val == T2.val){
                found = sameSubtree(T1, T2);
            }
            if(!found){
                found = isSubtree(T1.left, T2);
            }
            if(!found){
                found = isSubtree(T1.right, T2);
            }
        }
        return found;
    }
}

