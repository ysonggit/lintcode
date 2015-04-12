public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        s = s.trim();
        String str [] = s.split(" ");
        StringBuilder rev = new StringBuilder();
        for(int i=str.length-1; i>=0; i--){
            rev.append(str[i]);
            if(i!=0) rev.append(" ");
        }
        return rev.toString();
    }
}
