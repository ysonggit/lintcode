public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        HashMap<Character, Integer> char_count_A = new HashMap(); 
        for(int i=0; i<A.length(); i++){
            char cur = A.charAt(i);
            if(!char_count_A.containsKey(cur)){
                char_count_A.put(cur, 1);
            }else{
                char_count_A.put(cur, char_count_A.get(cur)+1);
            }
        }
        for(int i=0; i<B.length(); i++){
            char cur = B.charAt(i);
            if(!char_count_A.containsKey(cur)) return false;
            else{
                if(char_count_A.get(cur) <= 0) return false;
                else char_count_A.put(cur, char_count_A.get(cur)-1);
            }
        }
        return true;
    }
}
