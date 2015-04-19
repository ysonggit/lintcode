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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if(head==null) return null;
        if(n==m) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        for(int i=1; i<m; i++){
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        ListNode rev_start = cur;
        ListNode rev_pre = null;
        ListNode rev_end = cur;
        int k = n -m + 1;
        while(k>0){
            ListNode rev_nex = rev_start.next;
            rev_start.next = rev_pre;
            rev_pre = rev_start;
            rev_start = rev_nex;
            k--;
        }
        pre.next = rev_pre;
        rev_end.next = rev_start;
        return dummy.next;
    }
}

