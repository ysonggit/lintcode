class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> S, ArrayList<Integer> sol, int cur_idx){
      
        if(!res.contains(sol)){
            ArrayList<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
        }
        for(int i=cur_idx; i<S.size(); i++){
            sol.add(S.get(i));
            int last_idx = sol.size()-1;
            dfs(res, S, sol, i+1);
            sol.remove(last_idx);
        }
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        Collections.sort(S);
        ArrayList<Integer> sol = new ArrayList<Integer>();
        dfs(res, S, sol, 0);
        return res;
    }
}


