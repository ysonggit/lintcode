public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
        global_min[i] global minimum reached at i
        local_min[i] local minimum reached at i
        [1 -1 -2 1]
        local 1
        global 1
        local 1 -1
        global 1 -1
        local 1 -1 -3
        global 1 -1 -3
        local 1 -1 -3 -3
        global 1 -1 -3 -3
     */
     
    public int minSubArray(ArrayList<Integer> nums) {
        int n = nums.size();
        int [] global_min = new int[n];
        int [] local_min = new int [n];
        global_min[0] = nums.get(0);
        local_min[0] = nums.get(0);
        for(int i=1; i<nums.size(); i++){
            local_min[i] = Math.min(local_min[i-1]+nums.get(i), nums.get(i));
            global_min[i] = Math.min(global_min[i-1], local_min[i]);
        }
        return global_min[n-1];
    }
}
