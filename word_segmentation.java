public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     * D[i] : is true if first i characters in s can be segmented into words
     * D[0] = true
     * D[i] = D[k] && s[k, i-1] is in dictionary
     */
    public boolean wordSegmentation(String s, Set<String> dict) {
        int n = s.length();
        if(n==0) return true;
         /**
          * http://www.cnblogs.com/lishiblog/p/4183748.html
          * just to pass two large data tests (WQNMB)
          * 
          */
        char[] chars = new char[256];
        for (String word : dict){
            for (int i=0;i<word.length();i++){
               chars[word.charAt(i)]++;
            }
        }
        for (int i = 0;i<s.length();i++){
           if (chars[s.charAt(i)]==0) return false;
        }
        
        boolean D[] = new boolean [n+1];
        D[0] = true;
        for(int i=1; i<=n; i++){
            D[i] = false;
            for(int k=i-1; k>=0; k--){
                if(dict.contains(s.substring(k, i)) && D[k]==true){
                    D[i] = true;
                    break;
                }
            }
        }
        return D[n];
    }
}
