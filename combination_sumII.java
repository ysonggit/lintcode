public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public void dfs(List<List<Integer>> res, int[] candidates, List<Integer> path, int cur_idx, int cur_sum, int target){
        if(cur_sum > target) return;
        if(cur_sum == target) {
            List<Integer> sol = new ArrayList<Integer>(path);
            res.add(sol);
            return;
        }
        int n = candidates.length;
        for(int i= cur_idx; i<n; i++){
            int cur = candidates[i];
            // mistake : can not use while(i<n-1 && cur==candidates[i+1]) i++;
            // for example [7,1,2,5,1,6,10], 8; [1,1,6] is also a valid combination
            // mistake : i> 0 is wrong 
            if (i>cur_idx && cur == candidates[i-1]) continue;
            path.add(cur);
            cur_sum += cur;
            // diff from combination sum : pass i+1 since one number can be used only once
            dfs(res, candidates, path, i+1, cur_sum, target);
            cur_sum -= cur;
            path.remove(path.size()-1);
        }
    } 
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = num.length;
        if(n==0) return res;
        Arrays.sort(num);
        List<Integer> path = new ArrayList<Integer>();
        dfs(res, num, path, 0, 0, target);
        return res;
    }
}


