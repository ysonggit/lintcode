public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        if(n==0) return 0;
        int back = n-1;
        while(back>=0 && s.charAt(back) !=' ') back--;
        return n-1-back;
    }
}

