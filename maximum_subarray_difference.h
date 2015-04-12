public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     * combine minimum subarray and maximum subarray II
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        int n = nums.size();
        if(n==0) return 0;
        int minleft[] = new int [n];// minleft[i]: min subarray sum from 0 to i
        int maxleft[] = new int [n];// maxleft[i]: max subarray sum from 0 to i
        int local_max=nums.get(0);
        maxleft[0] = local_max;
        int local_min=nums.get(0);
        minleft[0] = local_min;
        for(int i=1; i<n; i++){
            local_max = Math.max(local_max+nums.get(i), nums.get(i));
            maxleft[i] = Math.max(local_max, maxleft[i-1]);
            local_min = Math.min(local_min+nums.get(i), nums.get(i));
            minleft[i] = Math.min(local_min, minleft[i-1]);
        }
        int minright[] = new int[n];// minright[i]: min subarray sum from n-1 to i
        int maxright[] = new int[n];// maxright[i]: max subarray sum from n-1 to i
        local_max = nums.get(n-1);
        maxright[n-1] = local_max;
        local_min = nums.get(n-1);
        minright[n-1] = local_min;
        for(int i=n-2; i>=0; i--){
            local_max = Math.max(local_max+nums.get(i), nums.get(i));
            maxright[i] = Math.max(maxright[i+1], local_max);
            local_min = Math.min(local_min+nums.get(i), nums.get(i));
            minright[i] = Math.min(local_min, minright[i+1]);
        }
        int diff_maxleft_minright = Integer.MIN_VALUE;
        int diff_minleft_maxright = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            diff_maxleft_minright = Math.max(diff_maxleft_minright, Math.abs(maxleft[i]-minright[i+1]));
            diff_minleft_maxright = Math.max(diff_minleft_maxright, Math.abs(minleft[i]-maxright[i+1]));
        }
        return Math.max(diff_maxleft_minright, diff_minleft_maxright);
    }
}



