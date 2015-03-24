public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     * Kadane's algorithm
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        int max_ending_here = nums.get(0); //local max
        int max_so_far = nums.get(0); // global max
        for(int i=1; i<nums.size(); i++){
            int cur = nums.get(i);
            max_ending_here = Math.max(cur, max_ending_here+cur);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }
}
