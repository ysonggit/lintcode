public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     * D[i] means the max amount of money the first guy could obtain
     * when the remaining coins are from i+1, and its the first guy's turn.
     * he/she can choose either i or choose i with i+1
     * Max amount of choosing i: P1 = Ai + min(D[i+2],   D[i+3])
     *                                        -------    --------
     *                                  other gets Ai+1  gets Ai+1 and Ai+2
     * Max amount of choosing i/i+1: P2 = Ai + Ai+1 + min(D[i+3],   D[i+4])
     *                                                   -------    --------
     *                                         other gets Ai+2  gets Ai+2 and Ai+3
     * D[i] = Max(P1, P2)
     */
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        if(n==0) return false;
        if(n<=2) return true;
        int total = 0;
        for(int v : values) { total += v; }
        int D[] = new int [n];
        int P1 = 0, P2 = 0;
        // important: compute from right to left
        // similar to Dungeon Game 
        for(int i=n-1; i>=0; i--){
            int a = (i+2 < n) ? D[i+2] : 0;
            int b = (i+3 < n) ? D[i+3] : 0;
            int c = (i+4 < n) ? D[i+4] : 0;
            P1 = values[i] + Math.min(a, b);
            if(i==n-1) P2 = values[i];
            else P2 = values[i] + values[i+1] + Math.min(b, c);
            D[i] = Math.max(P1, P2);
        }
        return (D[0] > total - D[0]) ? true : false;
    }
}
