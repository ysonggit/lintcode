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
 */ 
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     * just copy next node to current node
     */
    public void deleteNode(ListNode node) {
        if(node ==null) return;
        if(node.next == null) {
            node = null;
        }else{
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}

