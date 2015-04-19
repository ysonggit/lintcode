/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int n=1;
        ListNode cur = head;
        while(cur.next != null){
            n++;
            cur = cur.next;
        }
        // connect tail with head
        cur.next = head;
        for(int i=0; i<n-k%n; i++){
            cur = cur.next;
        }
        ListNode newhead = cur.next;
        cur.next = null;
        return newhead;
    }
}

