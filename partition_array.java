public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    int n = nums.size();
	    if(n==0) return 0;
	    int i=0, j=n-1;
	    while(i<j){
	        // mistake : i<j will fail a corner case: 
	        // if every element is < k, should return n
	        while(i<=j && nums.get(i)<k) i++;
	        while(i<j && nums.get(j)>=k) j--;
	        if(i<j && nums.get(i)>=k && nums.get(j)<k) {
	            int tmp = nums.get(i);
	            nums.set(i, nums.get(j));
	            nums.set(j, tmp);
	        }
	    }
	    return i;
    }
}
