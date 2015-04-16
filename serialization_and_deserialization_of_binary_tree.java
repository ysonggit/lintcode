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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    StringBuilder vals = new StringBuilder();
    
    public void preorder(TreeNode root){
        if(root==null){
            if(vals.length()>0){
                vals.append(",#");
            }
            return;
        }
        if(vals.length()>0){
            vals.append(",");  
        }
        vals.append(String.valueOf(root.val));
        preorder(root.left);
        preorder(root.right);
    }
    public String serialize(TreeNode root) {
        preorder(root);
        return vals.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    String rest;
    public TreeNode helper() {
        if(rest.length()==0) return null;
        int comma_pos = rest.indexOf(",");
        if(comma_pos<0){
            return null;
        }else{
            String node_val = rest.substring(0, comma_pos);
            rest = rest.substring(comma_pos+1);
            if(!node_val.equals("#")){
                int val = Integer.parseInt(node_val);
                TreeNode node = new TreeNode(val);
                node.left =  helper();
                node.right = helper();
                return node;
            }
        }
        return null;
    }
    public TreeNode deserialize(String data){
        rest = new String(data);
        return helper();
    }
}

