public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        if(n<2) return n;
        int L[] = new int[n];
        int max_len = 1;
        for(int i=0; i<n; i++){
            L[i]=1;
            for(int j=0; j <i; j++){
                if(nums[j]<=nums[i]) {L[i]= Math.max(L[i], L[j]+1);}
            }
            max_len = Math.max(max_len, L[i]);
        }
        return max_len;
    }
}

