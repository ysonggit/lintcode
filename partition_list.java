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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode leftdummy = new ListNode(-1);
        ListNode rightdummy = new ListNode(-2);
        ListNode left = leftdummy;
        ListNode right = rightdummy;
        while(head != null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            }else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightdummy.next;
        return leftdummy.next;
    }
}

