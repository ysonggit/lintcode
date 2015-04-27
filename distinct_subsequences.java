public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     * D[i][j]: the number of distinct subsequences of first j chars in T shown in the first i chars in S
     * if s[i] != t[j]
     * D[i+1][j+1] = D[i][j]
     * else
     * D[i+1][j+1] = D[i][j] + D[i][j+1]
     */
    public int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();
        if(m<n) return 0;
        int D[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            D[i][0] = 1;
        }
        for(int i=1; i<=m; i++){
            char cur_char_in_s = S.charAt(i-1);
            for(int j=1; j<=n; j++){
                char cur_char_in_t = T.charAt(j-1);
                if(cur_char_in_s != cur_char_in_t){
                    // number of distinct subseq formed by i chars in S matching first j chars in T
                    // keeps the same as using first i-1 chars in S to form subseq matching first j chars in T
                    D[i][j] = D[i-1][j];
                }else{
                    // s= abb , t= ab 
                    // when i=2, j=1, s[i] == t[j] = b, 
                    // the ways of forming subseq of s using 3 chars to match 2 chars of t can be obtained by
                    // 1) choosing first 2 chars of s to match 2 chars of t; (don't use s[i])
                    // 2) using first 2 chars to match 1 char of t, meanwhile using current char of s (s[i]) to match t[j]
                    // D[3][2] = D[2][2] + D[2][1]
                    D[i][j] = D[i-1][j-1]+D[i-1][j];
                }
            }
        }
        return D[m][n];
    }
}

