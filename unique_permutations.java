class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, ArrayList<Integer> sol, boolean[] visited){
        if(sol.size()== nums.size()) {
            ArrayList<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
            return;
        }    
        for(int i=0; i<nums.size(); i++){
            if(i>0 && nums.get(i)==nums.get(i-1) && visited[i-1]) continue;
            if(!visited[i]){
                sol.add(nums.get(i));
                visited[i] = true;
                dfs(res, nums, sol, visited);
                visited[i] = false;
                sol.remove(sol.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();;
        if(nums.size()==0) return res;
        Collections.sort(nums);
        ArrayList<Integer> sol =new ArrayList<Integer>();
        boolean visited[] = new boolean[nums.size()]; // default false values
        dfs(res, nums, sol, visited);
        return res;
    }
}


