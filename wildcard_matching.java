public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     * DP 
     * D[i][j] : the first i characters in s matches the first j characters in p
     * 1) if current p[j-1] is not *
     * D[i][j]  is true if D[i-1][j-1] is true AND s[i-1] = p[i-1] 
     *                   OR D[i-1][j-1] is true AND p[i-1] = ?
     * 2) if current p[j-1] is *
     * D[i][j]  is true if D[i-1][j-1] is true (also D[i+1][j] ... D[n][j] are true)
     * Example: abacd  ab*  (i=3, j=3)
     *                  OR D[i][j-1] is true
     * Example: abaa  *b*  (i=4, j=3)
     */
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        if(m==0) return n==0;
        boolean D[][] = new boolean[n+1][m+1];
        D[0][0] = true;
        if(p.charAt(0)=='*') D[0][1]=true;
        
        // D[i][0] = false for all i > 0
        for(int i=1; i<=n; i++){
            char cs = s.charAt(i-1);
            for(int j=1; j<=m; j++){
                char cp = p.charAt(j-1);
                if(cp != '*'){
                    D[i][j] = D[i-1][j-1] && (cs == cp || cp == '?');
                }else{
                    if(D[i-1][j-1]){
                        for(int k=i; k<=n; k++){
                            D[k][j] = true;
                        }
                    }else{
                        if(D[i][j-1]) D[i][j] = true;
                    }
                }
            }
        }
        return D[n][m];
    }
}

