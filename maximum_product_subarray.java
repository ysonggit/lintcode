public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int global_max = nums[0], local_max = nums[0], local_min = nums[0];
        for(int i=1; i<n; i++){
            int cur  = nums[i];
            int prev_local_max = local_max;
            local_max = Math.max(cur, Math.max(local_max* cur, local_min*cur));
            local_min = Math.min(cur, Math.min(prev_local_max*cur, local_min*cur));
            global_max = Math.max(global_max, local_max);
        }
        return global_max;
    }
}

