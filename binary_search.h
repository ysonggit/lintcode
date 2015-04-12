class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int helper(int [] nums, int left, int right, int target){
        if(left > right) return -1;
        int mid = (left+right)/2;
        if(nums[mid]==target) {
            while(mid>0 && nums[mid-1]==nums[mid]) mid--;
            return mid;
        }
        if (nums[mid] < target){
            return helper(nums, mid+1, right, target);
        }
        if (nums[mid] > target){
            return helper(nums, left, mid-1, target);
        }
        return -1;
    }
     
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums.length == 0 ) return -1;
        int left = 0, right = nums.length-1;
        return helper(nums, left, right, target);
    }
}
