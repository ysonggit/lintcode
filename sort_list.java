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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
  
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(left !=null && right!=null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left != null) cur.next = left;
        if(right != null) cur.next = right;
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {  
        if(head==null) return null;
        if(head.next == null) return head;
        // split list into two halves
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next != null){ // mistake : fast!=null && fast.next.next !=null
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null; //break the list
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        return merge(left, right);
    }
}


