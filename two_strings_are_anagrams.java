public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        char [] sc = s.toCharArray();
        char [] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        String ss = new String(sc);
        String ts = new String(tc);
        return ss.equals(ts);
    }
};
