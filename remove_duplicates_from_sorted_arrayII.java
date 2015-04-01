public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int j = 1;
        int dup_count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                dup_count++;
            }else{
                dup_count = 1;
            }
            if(dup_count<=2){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
