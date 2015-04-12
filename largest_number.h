public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    class Comp implements Comparator<String>{
        public int compare(String a, String b){
            return (b.concat(a)).compareTo(a.concat(b));
            // different from c++ comparator : return a+b>b+a
        }    
    }
    
    public String largestNumber(int[] num) {
        StringBuilder res = new StringBuilder();
        if(num.length == 0) return res.toString();
        String strs[] = new String[num.length]; 
        for(int i=0; i<num.length; i++){
            strs[i]= String.valueOf(num[i]);
        }
        Arrays.sort(strs, new Comp());
        for(String s : strs){
            res.append(s);
        }
        // tip: filter extra 0's "0000"
        java.math.BigInteger bi = new java.math.BigInteger(res.toString());
        return bi.toString();
    }
}
