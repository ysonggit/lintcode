public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
     */
    public ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
		if(nums.size()==0) return nums;
		int n = nums.size();
		int i = n - 1;
		while(i>0 && nums.get(i-1) >= nums.get(i) ) i--;
		if(i==0) {
		    Collections.reverse(nums);
		    return nums;   
		}
		int pivot_idx = i-1;
		int j= pivot_idx + 1;
		while(j<n && nums.get(j) > nums.get(pivot_idx) ) j++;
		int least_greater_idx = j-1;
		Collections.swap(nums, pivot_idx, least_greater_idx);
		ArrayList<Integer> next_permu = new ArrayList<Integer>();
		int k=0;
		while( k<=pivot_idx){
		    next_permu.add(nums.get(k));
		    k++;
		}
		int q = n-1;
		while(q>pivot_idx){
		    next_permu.add(nums.get(q));
		    q--;
		}
		return next_permu;
    }
}
