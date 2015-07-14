public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     * bucket sort
     * maintains equality: A[i] = i
     */
    public int findMissing(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i<n){
            if(nums[i]<n && nums[i] != nums[nums[i]]){
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }else{ // important!
                i++; 
            }
        }
        for(int j = 0; j<n; j++){
            if(nums[j] != j) return j;
        }
        return n; // tricky!
    }
}
