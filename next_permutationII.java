public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     * Find the next permutation
     * 1. search from righ to left, find the first number that terminates the increasing subsequence, call it pivot
     * 2. serch from pivot back to right, find the smallest number that is greater than the pivot
     * 3. swap pivot with the least greater than number
     * 4. reverse from pivot+1 to the end of array
     */
    public void swap(int [] nums, int a, int b){
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }
     
    // two pointers
    public void reverseInplace(int[] nums, int begin, int end){
        int front = begin, back = end;
        while(front<back){
            swap(nums, front, back);
            front++;
            back--;
        }
    } 
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2) return;
        int i = n-1;
        while(i>0 && nums[i-1] >= nums[i]) i--; // mistake: use >=, not >  (duplicated numbers)
        if(i==0) { // reverse entire list
            reverseInplace(nums, 0, n-1);
            return;
        }    
        int pivot = i-1;
        while(i<n && nums[i] > nums[pivot]) i++;
        int leastgreater = i-1;
        swap(nums, pivot, leastgreater);
        reverseInplace(nums, pivot+1, n-1);
    }
}

