public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     * take care of special case: if contains only even/odd numbers
     */
    public void partitionArray(int[] nums) {
        int n = nums.length;
        if(n<2) return;
        int front = 0, back = n-1;
        while(front<back){
            // find the first odd number from front to end
            while(front<=back && (nums[front] %2 ==1)) front++;
            // find the first even number from end to front
            while(back>front && (nums[back]%2==0)) back--;
            if(front<back){
                int tmp = nums[front];
                nums[front]=nums[back];
                nums[back]= tmp;
            }
        }
    }
}

