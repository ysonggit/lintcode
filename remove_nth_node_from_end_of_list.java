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
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0 || head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;// important
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast= fast.next;
            slow= slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

