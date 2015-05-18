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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        int capacity = hashTable.length;
        if(capacity == 0) return hashTable;
        int new_capacity = 2 * capacity;
        ListNode[] newTable = new ListNode[new_capacity];
        Arrays.fill(newTable, null);
        for(int i =0; i<capacity; i++){
            ListNode head = hashTable[i];
            if(head==null) continue;
            while(head != null){
                int key = head.val;
                int pos = (key%new_capacity+new_capacity) % new_capacity;
                ListNode new_value = new ListNode(key);
                if(newTable[pos]==null){
                    newTable[pos] = new_value;
                }else{
                    ListNode listhead = newTable[pos];
                    while(listhead.next !=null) listhead = listhead.next;
                    listhead.next = new_value;
                }
                head = head.next;
            }
        }
        return newTable;
    }
};

