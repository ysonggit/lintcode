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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode recur(int[] inorder, int[] postorder, int in_start, int in_end, int post_start, int post_end, HashMap<Integer, Integer> inorder_pos)
    {
        if(in_start>in_end || post_start > post_end) return null;
        int root_val = postorder[post_end];
        TreeNode root = new TreeNode(root_val);
        int root_pos = inorder_pos.get(root_val);
        int left_size = root_pos - in_start;
        int right_size = in_end - root_pos;
        root.left = recur(inorder, postorder, in_start, root_pos-1, post_start, post_start+left_size-1, inorder_pos);
        root.right = recur(inorder, postorder, root_pos+1, in_end, post_end-right_size, post_end-1, inorder_pos); // mistake : post_end
        return root; 
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n==0) return null;
        HashMap<Integer, Integer> inorder_pos = new HashMap<Integer, Integer>();
        for(int i=0; i<n;i++){
            inorder_pos.put(inorder[i], i);
        }
        return recur(inorder, postorder, 0, n-1, 0, n-1, inorder_pos);
    }
}

