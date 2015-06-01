/*public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     * O(nlogk) time O(k) space
     * TLE 
     *

    class MaxHeapCmp implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return b - a ;
        }
    } 
    
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k==0) return res;
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k, new MaxHeapCmp());
        for(int i=0; i<k; i++){
            maxheap.offer(nums[i]);
        }
        res.add(maxheap.peek());
        for(int i=k; i<nums.length; i++){
            int cur = nums[i];
            int eldest = i - k;
            maxheap.remove(nums[eldest]);
            maxheap.offer(cur);
            res.add(maxheap.peek());
        }
        return res;
    }
}
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     * O(n) time O(k) space
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k==0|| n==0) return res;
        // deque maintains the maximum number of current window of size k
        // the first element in deque is the index of the max number in the window
        // from the second to the end of deque, they are candidates of max elements in window
        Deque<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<k; i++){
            while(!q.isEmpty() && nums[i] > nums[q.getLast()]){
                q.removeLast();
            }
            q.offerLast(i);
        }
        res.add(nums[q.getFirst()]);
        for(int i=k; i<n; i++){
            while(!q.isEmpty() && i - q.getFirst()>=k){
                // the max is too old (outside window) should drop element
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[i] > nums[q.getLast()]){
                q.removeLast();
            }
            q.offerLast(i);
            res.add(nums[q.getFirst()]);
        }
        return res;
    }
}
