public class Solution {
    public boolean isPalindrome(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    
    public void dfs(List<List<String>> res, List<String> sol, String s, int start_idx){
        if(start_idx == s.length()){
            List<String> path = new ArrayList<String>(sol);
            res.add(path);
            return;
        }
        for(int i=start_idx; i<s.length(); i++){
            String cur = s.substring(start_idx, i+1);
            if(isPalindrome(cur)){
                sol.add(cur);
                dfs(res, sol, s, i+1);
                sol.remove(sol.size()-1);
            }
        }
    }
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.isEmpty()) return res;
        List<String> sol = new ArrayList<String>();
        dfs(res, sol, s, 0);
        return res;
    }
}
