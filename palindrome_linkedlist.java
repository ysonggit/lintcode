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
     * @return a boolean
     */
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode rev = reverseList(mid);
        while(rev!=null && head!=null){
            if(rev.val != head.val) return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }
}
