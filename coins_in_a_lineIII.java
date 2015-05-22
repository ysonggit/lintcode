public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     * D[i][j] means the max amount of money the first guy could obtain
     * when the remaining coins are from i to j, and its the first guy's turn.
     * he/she can choose either i or j
     * max amount if chosing i: Pi = Ai + min(D[i+2][j],   D[i+1][j-1])
     *                                        ---------     -----------
     *                                       other gets Ai+1  other gets Aj
     *            if chosing j: Pj = Aj + min(D[i+1][j-1],   D[i][j-2])
     *                                        -----------    ----------
     *                                       other gets Ai   other gets Aj-1
     * therefore, D[i][j] = max(Pi, Pj)
     */
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        if(n==0) return false;
        if(n==1) return true;
        int D[][] = new int [n][n];
        int Pi=0, Pj=0;
        int total = 0;
        for(int v : values){ total += v; }
        for(int back=0; back<n; back++){
            for(int i=0, j=back; j<n; i++, j++){
                int a = (i+2 < n) ? D[i+2][j] : 0;
                int b = (j-2 >=0) ? D[i][j-2] : 0;
                int c = (i+1 <n && j-1>=0) ? D[i+1][j-1] : 0;
                Pi = values[i] + Math.min(a, c);
                Pj = values[j] + Math.min(c, b);
                D[i][j] = Math.max(Pi, Pj);
            }
        }
        return (D[0][n-1] > (total - D[0][n-1])) ?  true : false;
    }
}

