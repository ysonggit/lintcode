public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     * [4 5 1 2 3]
     * 1. inplace reverse  4 5 -> 5 4
     * 2. inplace reverse  1 2 3 -> 3 2 1
     * combine 5 4 3 2 1
     * inplace reverse
     */
    public void inplaceReverse(ArrayList<Integer> nums, int start, int end){
        while(start<end){
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start++;
            end--;
        }    
    }
    
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int n = nums.size();
        if(n<=1) return ;
        int start_idx = -1;
        for(int i=1; i<n; i++){
            if(nums.get(i)<nums.get(i-1)) {
                start_idx = i;
                break;
            }
        }
        if(start_idx>0){
            inplaceReverse(nums, 0, start_idx-1);
            inplaceReverse(nums, start_idx, n-1);
            inplaceReverse(nums, 0, n-1);
        }
    }
}

