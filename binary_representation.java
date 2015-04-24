public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     * for this type of question, should :
     * be careful of negative (signed number)
     * be careful of overflow
     * this question assumes unsigned number
     * for fraction problem
     * precision is a problematic part
     */
    public String binaryRepresentation(String n) {
        if(n.length()==0) return n;
        int dot_pos = n.indexOf('.');
        Integer intpart = Integer.valueOf(n.substring(0, dot_pos));
        //Float frapart = Float.parseFloat(n.substring(dot_pos)); float precision is not enough!
        Double frapart = Double.valueOf(n.substring(dot_pos));
        StringBuilder left = new StringBuilder();
        while(intpart>0){
            char cur_bit = '0'; 
            if(intpart% 2 ==1) cur_bit = '1';// mistake : (intpart & 1 ) returns an int not boolean
            left.insert(0, cur_bit);
            intpart = intpart >>1;
        }
        if(left.length()==0) left.append('0');
        StringBuilder right = new StringBuilder();
        int BINARY_LIMITS = 32;
        while(frapart>0){
            if(right.length() > BINARY_LIMITS) return "ERROR";
            frapart *= 2;
            if(frapart>=1){ // mistake : don't use > !!
                frapart -= 1;
                right.append('1');
            }else{
                right.append('0');
            }
        }
        if(right.length()==0) return left.toString();
        return left.append('.').append(right).toString();
    }
}

