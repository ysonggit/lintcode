/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public int getLength(ListNode head){
        int len =0;
        ListNode cur = head;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        return len;
    }
    ListNode curhead;
    public TreeNode helper(int n){
        if(curhead==null || n<=0) return null;
        TreeNode left = helper(n/2);
        TreeNode root = new TreeNode(curhead.val);
        root.left = left;
        curhead = curhead.next;
        TreeNode right = helper(n-n/2-1);// mistake : n-n/2 : 1->2->3 3 should be the root
        root.right = right;
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {  
        int n = getLength(head);
        if(n==0) return null;
        curhead = head;
        return helper(n);
    }
}


