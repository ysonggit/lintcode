public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     * similar to combination sum
     */ 
    
    public void dfs(ArrayList<ArrayList<Integer>> res, int A[], ArrayList<Integer> sol, int cur_idx, int target, int k){
        if(cur_idx > A.length || target < 0 || sol.size() >k) return;
        if(target==0 && sol.size()==k){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        for(int i = cur_idx; i< A.length; i++){
            int cur_num = A[i];
            sol.add(cur_num);
            dfs(res, A, sol, i+1, target-cur_num, k);
            sol.remove(sol.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = A.length;
        if(n==0) return res;
        ArrayList<Integer> sol = new ArrayList<Integer>();
        dfs(res, A, sol, 0, target, k);
        return res;
    }
}
