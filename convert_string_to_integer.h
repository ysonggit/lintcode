public class Solution {
    /**
     * @param str: A string
     * @return An integer
     * +/-
     * spaces
     * overflow
     * 
     */
    public boolean overflow(int cur_num, int new_digit){
        if(cur_num > Integer.MAX_VALUE/10) return true;
        if(cur_num == Integer.MAX_VALUE/10 && new_digit > Integer.MAX_VALUE%10) return true;
        return false;
    }
    
    public int atoi(String str) {
       if(str==null ||str.length()==0) return 0;
       String s = str.trim();
       int sign = 1;
       int i = 0;
       if(s.charAt(0) == '-') {
           sign = -1;
           i++;
       }
       if(s.charAt(0) == '+') i++;
       int num = 0;
       while(i<s.length()){
           if(!Character.isDigit(s.charAt(i) ) ) return sign*num; 
           if(overflow(num, s.charAt(i)-'0' )) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
           }
           
           num = num * 10 + (s.charAt(i) - '0');
           i++;
       }
       return sign * num;
    }
}
