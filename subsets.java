class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public void dfs(ArrayList<ArrayList<Integer>> res, 
            ArrayList<Integer> S, ArrayList<Integer> sol, int cur_idx){
                if(cur_idx == S.size()){
                    ArrayList<Integer> path = new ArrayList<Integer>(sol);
                    res.add(path);
                    return;
                }
                // do not select this element
                dfs(res, S, sol, cur_idx+1);
                // select current element into subset
                sol.add(S.get(cur_idx));
                dfs(res, S, sol, cur_idx+1);
                sol.remove(sol.size()-1);
            }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S.size()==0) return res;
        Collections.sort(S);
        ArrayList<Integer> sol = new ArrayList<Integer>();
        dfs(res, S, sol, 0);
        return res;
    }
}
