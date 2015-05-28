public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     * empty
     * sign
     * whitespaces in between
     * e
     * point
     * how about -.123?
     */
    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if(n==0) return false;
        int sign = 1;
        int i = 0;
        if(s.charAt(i)=='+'){
            i++;
            if(n==1) return false;
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        if(s.charAt(i)=='-'){
            i++;
            sign = -1;
            if(n==1) return false;
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        int dot_count = 0;
        int e_count = 0;
        while(i<n){
            char cur = s.charAt(i);
            if(cur == ' ') return false;
            if(Character.isDigit(cur)) {
                i++; 
                continue;
            }
            if(cur=='.'){
                if(dot_count==0){
                    dot_count=1;
                    i++;
                    if(i==n) return false;// .
                    continue;
                }else{
                    return false;
                }
            }
            if(Character.isLetter(cur)){
                if(cur != 'e') return false;
                if(e_count==0){
                    if(i==0) return false; //e9
                    if(i>0 && Character.isDigit(s.charAt(i-1))){
                        e_count= 1;
                        i++;
                        if(i==n) return false; // e
                        continue;
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
