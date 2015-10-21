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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public int getLength(ListNode head){
        if(head==null) return 0;
        int len = 1;
        while(head.next!=null){
            head = head.next;
            len++;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int lenA = getLength(headA), lenB = getLength(headB);
       if(lenA==0 || lenB==0) return null;
       if(lenA>lenB){
           for(int i=0; i<lenA-lenB; i++) headA = headA.next;
       }else if(lenA<lenB){
           for(int i=0; i<lenB-lenA; i++) headB = headB.next;
       }
       for(int i=0; i<Math.min(lenA, lenB); i++){
           if(headA == headB) return headA;
           headA = headA.next;
           headB = headB.next;
       }
       return null;
    }  
}
