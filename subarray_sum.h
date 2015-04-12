public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     * becare full of corner case: [0]
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        int n = nums.length;
        if(n==0) return new ArrayList<Integer>();
        int target = 0;
        for(int i=0; i<n; i++){
            int cur_sum = nums[i];
            if(cur_sum == target){
                return new ArrayList<Integer>(Arrays.asList(i,i));
            }
            for(int j=i+1; j<n; j++){
                cur_sum += nums[j];
                if(cur_sum == target){
                    return new ArrayList<Integer>(Arrays.asList(i,j));
                }
            }
        }
        return new ArrayList<Integer>();
    }
}
