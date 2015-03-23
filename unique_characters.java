public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        int [] chars = new int [256];
        for(int i=0; i<str.length(); i++){
            int cur_idx = (int) str.charAt(i);
            if(chars[cur_idx] > 0) return false;
            else chars[cur_idx] += 1;
        }
        return true;
    }
}
