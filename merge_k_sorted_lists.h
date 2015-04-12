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
class NodeComparator implements Comparator<ListNode>{
    public int compare(ListNode x, ListNode y){
        return x.val - y.val;
    }    
}
 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        int k = lists.size();
        if(k==0) return null;
        PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>(k, new NodeComparator());
        for(int i=0; i<k; i++){
            if(lists.get(i) != null){
                minheap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode to_insert = null;
        while(!minheap.isEmpty()){
            to_insert = minheap.peek().next;
            cur.next = minheap.poll();
            cur = cur.next;
            if(to_insert != null) {
                minheap.add(to_insert);
            }
        }
        return dummy.next;
    }
}

