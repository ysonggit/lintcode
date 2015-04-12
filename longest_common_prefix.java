public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if(strs.length==0) return prefix.toString();
        for(int i=0; i<strs[0].length(); i++){
            char cur = strs[0].charAt(i);
            for(int k=1; k<strs.length; k++){
                if(strs[k].length() == i) return prefix.toString();
                if(strs[k].charAt(i) != cur) return prefix.toString();
            }
            prefix.append(cur);
        }
        return prefix.toString();
    }
}
