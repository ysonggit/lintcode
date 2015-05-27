public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     * similar to subarray sum
     */
    public int minimumSize(int[] nums, int s) {
        int n = nums.length;
        if(n==0) return 0;
        int min_len = n+1;
        int start=0, i = 0;
        int cur_sum = 0;
        while(i<n){
            if(nums[i]>=s) return 1; 
            cur_sum += nums[i];
            if(cur_sum >= s){ 
                min_len = Math.min(min_len, i-start+1);
                start++; // mistake: start = i+1 is wrong
                cur_sum = 0;
                i = start;
            }else{
                i++;
            }
        }
        return (min_len>n) ? 0 : min_len; // mistake: this kind of subarray may not exist!
    }
}
