class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k>=n){
            int max_profit = 0;
            for(int i=1; i<n; i++){
                int diff = prices[i] - prices[i-1];
                if(diff>0) max_profit += diff;
            }
            return max_profit;
        }
        int D[][] = new int[n][k+1];
        // D[i][j]: the max profit at prices[i] with j transactions
        for(int j=1; j<=k; j++){
            int max_gain_from_trans_j = D[0][j-1] - prices[0];
            for(int i=1; i<n; i++){
                D[i][j]= Math.max(D[i-1][j], prices[i]+ max_gain_from_trans_j);
                max_gain_from_trans_j = Math.max(D[i][j-1] - prices[i], max_gain_from_trans_j);
            }
        }
        return D[n-1][k];
    }
};
