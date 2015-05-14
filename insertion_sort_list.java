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
     * @return: The head of linked list.
     * for i = 1 to length(A) - 1
            j = i
            while j > 0 and A[j-1] > A[j]
                // insert to the pos before the first one > it
                swap A[j] and A[j-1]
                j = j - 1
            end while
        end for
     */
    public ListNode insert(ListNode dummy, ListNode pre, ListNode to_insert){
        ListNode pos = dummy;
        pre.next = to_insert.next;
        // d -> 1 -> 2 -> 5 -> 6 -> 4 -> 3
        //           --        --   --
        //            |-pos    |-pre |-to_insert
        while(pos.next != null && pos.next.val < to_insert.val){
            pos = pos.next;
        }
        to_insert.next = pos.next;
        pos.next = to_insert;
        return pre;
    }
     
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        if(head.next ==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        while(cur != null && cur.next != null){
            if(cur.next.val > cur.val){
                cur = cur.next;
            }else{
                // 1. find the first node greater than cur.next
                // 2. insert cur.next to that node
                // 3. return new cur node
                cur = insert(dummy, cur, cur.next);
            }
        }
        return dummy.next;
    }
}

