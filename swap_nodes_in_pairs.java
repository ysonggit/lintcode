/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while(cur !=null && cur.next!=null){
            // pre -> cur -> cur.next -> X
            ListNode nexnex = cur.next.next;
            pre.next = cur.next;
            pre.next.next = cur;
            cur.next = nexnex;
            pre = pre.next.next;
            cur = nexnex;
        }
        return dummy.next;
    }
}
