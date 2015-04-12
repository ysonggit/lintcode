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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry_bit = 0;
        int a=0,b=0;
        while(l1 != null || l2!=null){
            a = (l1==null) ? 0 : l1.val;
            b = (l2==null) ? 0 : l2.val;
            int cur_bit = (a+b+carry_bit)%10;
            carry_bit = (a+b+carry_bit)/10;
            cur.next = new ListNode(cur_bit);
            cur = cur.next;
            if(l1!= null) l1 = l1.next;
            if(l2!= null) l2 = l2.next;
        }
        if(carry_bit>0){
            cur.next = new ListNode(carry_bit);
        }
        return dummy.next;
    }
}

