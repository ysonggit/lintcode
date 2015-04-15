class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     * [1 0 0 1 2 1 2 1 0]
     * use two pointers: r - last red ends at this pos
     *                   b - first blue starts at this pos
     * trick : intialize r as -1 and b as n
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n==0) return;
        int r = -1, b = n;
        int i = 0;
        while(i<b){
            if(nums[i]==0){
                r++;
                int tmp = nums[i];
                nums[i] = nums[r];
                nums[r] = tmp;
                i++;
            }
            else if(nums[i]==1){
                // i moves forward
                i++;  
            } 
            else {
                b--;
                int tmp = nums[i];
                nums[i] = nums[b];
                nums[b] = tmp;
                // i stays at current pos
            }
        }
    }
}

