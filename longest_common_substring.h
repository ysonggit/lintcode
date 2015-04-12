public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     *  The longest common suffix has following optimal substructure property
       LCSuff(X, Y, m, n) = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1]
                            0  Otherwise (if X[m-1] != Y[n-1])
        The maximum length Longest Common Suffix is the longest common substring.
       LCSubStr(X, Y, m, n)  = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m
                                                         and 1 <= j <= n
     */
    public int longestCommonSubstring(String A, String B) {
        int m = A.length(), n = B.length();
        int [] [] LCSuff = new int[m+1][n+1];
        int lcs = 0;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    LCSuff[i][j] = 0;
                } 
                else if(A.charAt(i-1) == B.charAt(j-1)) {
                    LCSuff[i][j] = LCSuff[i-1][j-1] + 1;
                    lcs = Math.max(lcs, LCSuff[i][j]);
                }else{
                    LCSuff[i][j] = 0;
                }
            }
        }
        return lcs;
    }
}
