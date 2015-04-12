public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // moore's voting algorithm
        if(nums.size()==0) return 0;
        int maj_idx = 0;
        int count = 1;
        for(int i=1; i<nums.size(); i++){
            int cur = nums.get(i);
            if(nums.get(maj_idx) == cur){
                count++;
            }else{
                count--;
            }
            if(count==0){
                maj_idx = i;
                count = 1;
            }
        }
        return nums.get(maj_idx);
    }
}
