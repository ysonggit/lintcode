public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		int n = nums.size();
		if(n==0) return nums;
		int i = n-1;
		while(i>0 && nums.get(i-1) <= nums.get(i)) i--;
		if(i==0) {
		    Collections.reverse(nums);
		    return nums;
		}
		int pivot_idx = i - 1;
		int j = i+1;
		while(j<n && nums.get(j) < nums.get(pivot_idx)) j++;
		int last_less_than_idx = j - 1;
		Collections.swap(nums, pivot_idx, last_less_than_idx);
		ArrayList<Integer> prev_permu = new ArrayList<Integer>();
		for(int k=0; k<=pivot_idx; k++){
		    prev_permu.add(nums.get(k));
		}
		for(int q = n-1; q>pivot_idx; q--){
		    prev_permu.add(nums.get(q));
		}
		return prev_permu;
    }
}
