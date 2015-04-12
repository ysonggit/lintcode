class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public void dfs(ArrayList<Integer> sol, ArrayList<Integer> nums, int cur_idx, int []visited){
        if(cur_idx == nums.size()){
            ArrayList<Integer> p = new ArrayList<Integer>(sol);
            res.add(p);
            return ;
        }        
        for(int i=0;i<nums.size(); i++){
            if(visited[i]==0){
                sol.add(nums.get(i));
                visited[i] = 1;
                dfs(sol, nums, cur_idx+1, visited);
                visited[i]=0;
                sol.remove(sol.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        if(nums == null) return res;
        ArrayList<Integer> sol = new ArrayList<Integer>();
        int visited[] = new int[nums.size()];
        dfs(sol, nums, 0, visited);
        return res;
    }
}

