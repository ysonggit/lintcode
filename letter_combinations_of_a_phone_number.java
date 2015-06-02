public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public String getLetters(char c){
        String [] comb = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int i = (int) (c) - (int)'0';
        return comb[i];
    } 
    
    public void dfs(ArrayList<String> res, String digits, int cur_idx, StringBuilder sol){
        if(cur_idx == digits.length()){
            res.add(sol.toString());
            return ;
        }
        String candidates = getLetters(digits.charAt(cur_idx));
        for(int i=0; i<candidates.length(); i++){
            sol.append(candidates.charAt(i));
            dfs(res, digits, cur_idx+1, sol);
            sol.deleteCharAt(sol.length()-1);
        }
    }
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if(digits.length()==0) return res;
        StringBuilder sol = new StringBuilder();
        dfs(res, digits, 0, sol);
        return res;
    }
}
