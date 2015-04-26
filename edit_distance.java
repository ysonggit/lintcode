public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     * D[i][j]: minimal cost of editing first i characters in word1 to first j characters in word2
     * D[i][j] = min{ D[i-1][j] + D // delete the char j
     *                D[i][j-1] + I // insert the char j
     *                D[i-1][j-1] + R // replace i or j
     *               }
     * D[0][0] = 0
     * D[i][0] = i
     * D[0][j] = j
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int D[][] = new int [m+1][n+1];
        for(int i=1; i<=m; i++){
            D[i][0] = i;
        }
        for(int j=1; j<=n; j++){
            D[0][j] = j;
        }
        for(int i=1; i<=m; i++){
            char cur_char_in_word1 = word1.charAt(i-1);
            for(int j=1; j<=n; j++){
                char cur_char_in_word2 = word2.charAt(j-1);
                if(cur_char_in_word1 == cur_char_in_word2){
                    D[i][j] = Math.min(Math.min(D[i-1][j], D[i][j-1])+1, D[i-1][j-1]);
                }else{
                    D[i][j] = Math.min(Math.min(D[i-1][j], D[i][j-1])+1, D[i-1][j-1]+1);
                }
            }
        }
        return D[m][n];
    }
}

