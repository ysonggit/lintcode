/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     * assume labels are unique
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        HashMap<Integer, RandomListNode> copied = new HashMap<Integer, RandomListNode>();
        RandomListNode cur = head;
        while(cur != null){
            int cur_label = cur.label;
            if(!copied.containsKey(cur_label)){
                copied.put(cur_label, new RandomListNode(cur_label));
            }
            if(cur.next != null){
                int next_label = cur.next.label;
                if(!copied.containsKey(next_label)){
                    copied.put(next_label, new RandomListNode(next_label));
                }
                copied.get(cur_label).next = copied.get(next_label);
            }
            if(cur.random != null){
                int rand_label = cur.random.label;
                if(!copied.containsKey(rand_label)){
                    copied.put(rand_label, new RandomListNode(rand_label));
                }
                copied.get(cur_label).random = copied.get(rand_label);
            }
            cur = cur.next;
        }
        return copied.get(head.label);
    }
}

