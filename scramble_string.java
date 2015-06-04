public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     * s1 = s11+s12
     * s2 = s21+s22
     * isScramble(s1,s2) returns true if
     *    isScramble(s11,s21) && isScramble(s12, s22)
     *    or
     *    isScramble(s11,s21_) && isScramble(s12, s22_)
     */
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if(n==0) return s2.length()==n; // empty string
        if(n==1) return s1.equals(s2);  // one char string
        char s1chars [] = s1.toCharArray();
        char s2chars [] = s2.toCharArray();
        Arrays.sort(s1chars);
        Arrays.sort(s2chars);
        if(!Arrays.equals(s1chars, s2chars)) return false;
        boolean scramble = false;
        for(int len=1; len<=n; len++){ // important: terminate loop if found scramble
            String s11=s1.substring(0, len);
            String s12=s1.substring(len,n);
            String s21=s2.substring(0, len);
            String s22=s2.substring(len, n);
            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
            String s21_ = s2.substring(n-len, n);
            String s22_ = s2.substring(0, n-len);
            if(isScramble(s11, s21_) && isScramble(s12, s22_) ) return true;
        }
        return false;
    }
}
