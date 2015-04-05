public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length(), m = B.length();
        int LCS[][] = new int[n+1][m+1]; // default value 0s
        for(int i=1; i<=n; i++){
            char last_char_A = A.charAt(i-1);
            for(int j=1; j<=m; j++){
                char last_char_B = B.charAt(j-1);
                if(last_char_A == last_char_B){
                    LCS[i][j] = LCS[i-1][j-1]+1;
                }else{
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }        
        return LCS[n][m];
    }
}

