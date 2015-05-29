public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        String roman_letters = "IVXLCDM";
        int numeric [] = {1, 5, 10, 50, 100, 500, 1000};
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<numeric.length; i++){
            map.put(roman_letters.charAt(i), numeric[i]);
        }
        int res = 0;
        // assume given string is always valid
        for(int i=0; i<s.length(); i++){
            if(i>0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1))){
                res += map.get(s.charAt(i)) - 2*map.get(s.charAt(i-1));
            }else{
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
