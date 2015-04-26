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
     * @paramn n: An integer
     * @return: A list of root
     * corner case : n=0, return a list contains a NULL
     */
    public void dfs(List<TreeNode> subtrees, int leftchild, int rightchild){
        if(leftchild>rightchild){ // in BST, leftchild < rightchild
            subtrees.add(null);
            return;
        }
        for(int i=leftchild; i<=rightchild; i++){
            // given i, make it as the root of a subtree
            // create its left subtree and right subtree
            List<TreeNode> leftsubtree= new ArrayList<TreeNode>();
            List<TreeNode> rightsubtree = new ArrayList<TreeNode>();
            dfs(leftsubtree, leftchild, i-1);
            dfs(rightsubtree, i+1, rightchild);
            // make new node of i as root, for this root, any node in leftsubtree could
            // be its leftsubtree root, same for the rightsubtree
            for(TreeNode left_node: leftsubtree){
                for(TreeNode right_node: rightsubtree){
                    TreeNode root = new TreeNode(i);
                    root.left = left_node;
                    root.right = right_node;
                    subtrees.add(root);
                }
            }
        }
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> subtrees = new ArrayList<TreeNode>();
        if (n==0) {
            subtrees.add(null);
            return subtrees;
        }
        dfs(subtrees, 1, n);
        return subtrees;
    }
}

