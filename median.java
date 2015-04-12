public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     * c++ priorityqueue default is a maxheap
     * for minheap:
     * priority_queue<int, vector<int>, greater<int> > min_heap(nums.begin(), nums.end()); 
     */
    public int median(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        for(int i : nums){
            minheap.offer(i);
        }
        int m = (n%2==0) ? ((n/2)-1) : n/2;
        for(int j=0; j<m; j++){
            minheap.poll();
        }
        return minheap.peek();
    }
}


