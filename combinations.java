public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public void dfs(List<List<Integer>> res, List<Integer> sol, 
                    int cur, int n, int k, int count){
        if(count==k){
            List<Integer> comb = new ArrayList<Integer>(sol);
            res.add(comb);
            return ;
        }
        for(int i=cur; i<=n; i++){
            sol.add(i);
            dfs(res, sol, i+1, n, k, count+1);
            sol.remove(sol.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n==0 || k<=0 || k>n) return res;
		List<Integer> sol = new ArrayList<Integer>();
		dfs(res, sol, 1, n, k, 0);
		return res;
    }
}

