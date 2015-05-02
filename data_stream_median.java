public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     * minheap store the larger half of numbers
     * maxheap store the smaller half of numbers
     * maxheap.size >= minheap.size
     * always return root of maxheap 
     */
    class CmpForMaxheap implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return b - a; // a less than b
        }    
    }
    
    PriorityQueue<Integer> minheap; 
    PriorityQueue<Integer> maxheap; 
    public void addNumber(int x){
        if(minheap.size() == maxheap.size()){
            // sizes maybe both 0s
            if(maxheap.isEmpty()){
                // means minheap is also empty
                maxheap.offer(x);
            }else{
                // both heaps not empty: decide x to go which part
                // KEY: min_top matters
                Integer min_top = minheap.peek();
                if(x > min_top){
                    // x should go to the larger half, but make sure the maxheap size >= minheap size
                    maxheap.offer(minheap.poll());
                    minheap.offer(x);
                }else{
                    // move x to the smaller half
                    maxheap.offer(x);
                }
            }
        }else{
            // maxheap size > minheap size
            // KEY: max_top matters
            Integer max_top = maxheap.peek();
            if(x> max_top){
                // x should go to the larger half 
                minheap.offer(x);
            }else{
                // x should go to the smaller half, but make sure move top from maxheap to minheap
                minheap.offer(maxheap.poll());
                maxheap.offer(x);
            }
        }
    }
    int getMedian(){
        if(maxheap.isEmpty()) return -1;
        return maxheap.peek();
    }
    
    public int[] medianII(int[] nums) {
        int n= nums.length;
        int medians[] = new int[n];
        minheap = new PriorityQueue<Integer>(n);
        maxheap = new PriorityQueue<Integer>(n, new CmpForMaxheap());
        if(n==0) return medians;
        for(int i =0; i<n; i++){
            addNumber(nums[i]);
            medians[i] = getMedian();
        }
        return medians;
    }
}

