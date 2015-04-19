  

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public class SumToIth{
        int val;
        int idx;
        public SumToIth(int v, int i){
            val = v;
            idx = i;
        }
    }
    public class SumToIthCmp implements Comparator<SumToIth> {
        public int compare(SumToIth a, SumToIth b){
            return a.val - b.val; // ascending order
        }
    }
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n==0) return res;
        int sum = 0;
        ArrayList<SumToIth> sums = new ArrayList<SumToIth>();
        for(int i=0; i<n; i++){
            sum += nums[i];
            sums.add(new SumToIth(sum, i));
        }
        Collections.sort(sums, new SumToIthCmp()); // mistake: Collections.sort(sums, SumToIthCmp);
        int min_diff = Integer.MAX_VALUE;
        int start = 0, end = 0;
        for(int i=0; i<n-1; i++){
            int diff = Math.abs(sums.get(i+1).val-sums.get(i).val);
            if(diff<min_diff){
                min_diff=  diff;
                // mistake don't forget to +1
                start = Math.min(sums.get(i+1).idx, sums.get(i).idx)+1;
                end = Math.max(sums.get(i+1).idx, sums.get(i).idx);
            }
        }
        res.add(start);
        res.add(end);
        return res;
    }
}

