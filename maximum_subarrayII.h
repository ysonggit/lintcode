public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     * similar questions: trapping rain water  / best time to buy and sell stock III  
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int n = nums.size();
        if(n==0) return 0;
        int left [] = new int[n];
        // left[i] : the max subarray sum from 0 to i
        int local_max = nums.get(0);
        left[0] = local_max;
        for(int i=1; i<n; i++){
            local_max = Math.max(local_max+nums.get(i), nums.get(i));
            left[i] = Math.max(local_max, left[i-1]);
        }
        int right[] = new int[n];
        // right[i]: the max subarray sum from n-1 to i
        local_max = nums.get(n-1);
        right[n-1] = local_max;
        for(int i=n-2; i>=0; i--){
            local_max = Math.max(local_max+nums.get(i), nums.get(i));
            right[i] = Math.max(local_max, right[i+1]);
        }
        int global_max = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            global_max = Math.max(global_max, left[i]+right[i+1]);
        }
        return global_max;
    }
}



