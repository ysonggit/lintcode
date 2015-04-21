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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode recur(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end, HashMap<Integer, Integer> inorder_pos){
        if(pre_start> pre_end|| in_start > in_end) return null;
        int root_val = preorder[pre_start];
        TreeNode root = new TreeNode(root_val);
        int root_inorder_pos = inorder_pos.get(root_val);
        // build right subtree
        int right_size = in_end - root_inorder_pos;
        root.right = recur(preorder, inorder, pre_end-right_size+1, pre_end, root_inorder_pos+1, in_end, inorder_pos);
        int left_size = root_inorder_pos - in_start;
        root.left = recur(preorder, inorder, pre_start+1, pre_start+left_size, in_start, root_inorder_pos-1, inorder_pos);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n==0) return null;
        HashMap<Integer, Integer> inorder_pos = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            inorder_pos.put(inorder[i], i);
        }
        return recur(preorder, inorder, 0, n-1, 0, n-1, inorder_pos);
    }
}

