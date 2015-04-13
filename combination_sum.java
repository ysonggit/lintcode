public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public void dfs(List<List<Integer>> res, int[] candidates, List<Integer> path, int cur_idx, int cur_sum, int target){
        // mistake : check upperbound
        if(cur_sum > target) return;
        if(cur_sum == target) {
            List<Integer> sol = new ArrayList<Integer>(path);
            res.add(sol);
            return;
        }
        int n = candidates.length;
        for(int i= cur_idx; i<n; i++){
            int cur = candidates[i];
            while (i<n-1 && cur == candidates[i+1]) i++;
            if(i==n) return;
            path.add(cur);
            cur_sum += cur;
            // mistake : pass i not i+1 since one number can be used many times
            dfs(res, candidates, path, i, cur_sum, target);
            cur_sum -= cur;
            path.remove(path.size()-1);
        }
    } 
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = candidates.length;
        if(n==0) return res;
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<Integer>();
        dfs(res, candidates, path, 0, 0, target);
        return res;
    }
}

