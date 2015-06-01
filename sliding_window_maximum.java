public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     * O(nlogk) time O(k) space
     * TLE 
     */

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

