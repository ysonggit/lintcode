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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        if(head==null|| head.next ==null) return;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // split into halves
        ListNode slow = dummy.next;
        ListNode fast = dummy.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode righthead = slow.next;
        slow.next = null;
        ListNode lefthead = dummy.next;
        // reverse right half
        ListNode pre = null;
        ListNode cur = righthead;
        while(cur != null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        ListNode rev_righthead = pre;
        // rejoin two sublists
        cur = dummy;
        while(rev_righthead != null){
            ListNode nexcp = lefthead.next;
            lefthead.next = rev_righthead;
            rev_righthead = rev_righthead.next;
            lefthead.next.next = nexcp;
            lefthead = nexcp;
        }
        head = dummy.next;
    }
}


