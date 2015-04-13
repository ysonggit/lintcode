/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head ==null) return null;
        ListNode dummy = new ListNode (-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        boolean dup = false;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                dup = true;
                cur.next = cur.next.next;
            }
            if(dup){
                // delete cur
                pre.next = cur.next;
                cur = pre.next;
                dup = false;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
            
        }
        return dummy.next;
    }
}


