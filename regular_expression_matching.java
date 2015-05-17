public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     * DP
     * D[i][j] : the first i characters of s match the first j characters of p
     * 1) if current p[j-1] is not *
     * D[i][j]  is true if D[i-1][j-1] is true AND s[i-1] = p[i-1] 
     *                   OR D[i-1][j-1] is true AND p[i-1] = . 
     * 2) if current p[j-1] is *
     *                  if p[j-2] is not .
     * D[i][j]  is true if              
     * Matching Examples: 
     * bb  *
     * b   b*             D[i][j-1] is true          i=1, j=2
     * bb  b*             D[i-1][j] is true AND s[i-1] == s[i-2]  i=2, j=2
     * bbb b*             D[i-1][j] is true AND s[i-1] == s[i-2]  i=3, j=2
     * ""  b*             
     * aab c*a*b
     * NOT matching :
     * ba  b*
     * 
     *                  if p[j-2] is .
     * 
     * D[i][j] is true if:
     * Matching Exmaples:
     * aa  a.*            D[i][j-1] is true    i=2,j=3
     * aa  .*             D[i][j-1] is true    i=1,j=2
     * ab  .*             D[i][j-1] is true    i=1,j=2 
     * abc a.*c.*         D[i][j-2] is true    i=3,j=6
     * 
     */
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        if(m==0) return n==0;
        boolean D[][] = new boolean [n+1][m+1];
        D[0][0] = true;
        D[0][1] = (p.charAt(0) == '*');
        for(int j=2; j<=m; j++){
            if(p.charAt(j-1) == '*') D[0][j] = D[0][j-2]; // mistake : j-2 not j-1
        }
        for(int i=1; i<=n; i++){
            char cs = s.charAt(i-1); // be careful i-1
            for(int j=1; j<=m; j++){
                char cp = p.charAt(j-1);
                if(cp!='*'){
                    D[i][j] = D[i-1][j-1] && (cs == cp || cp =='.');
                }else{ // cp == '*'
                    if(j>1){ // check if previous char is . ?
                        if(p.charAt(j-2) != '.'){
                            D[i][j] = D[i][j-1];
                            if(i>1) {
                                D[i][j] = D[i][j-1] || (D[i-1][j] && s.charAt(i-1) == s.charAt(i-2));
                            }else{ // i==1
                                D[i][j] = D[i][j-1] || (D[i-1][j] );
                            }
                        }else{ // p[i-2]=='.'
                            if( D[i][j-1]|| D[i][j-2]){
                                for(int k=i; k<=n; k++) D[k][j]=true;
                            }
                        }
                    }
                }
            }
        }
        return D[n][m];
    }
}

