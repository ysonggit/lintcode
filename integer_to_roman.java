public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     * 1 4 5 9
     * 10 40 50 90 
     * 100 400 500 900 
     * 1000
     */
    public String intToRoman(int n) {
        int numeric [] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String roman [] = {"M","CM","D","CD","C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        while(n>0){
            for(int i=0; i<numeric.length; i++){
                if(n>=numeric[i]){
                    res.append(roman[i]);
                    n-= numeric[i];
                    break; // important!
                }
            }
        }
        return res.toString();
    }
}
