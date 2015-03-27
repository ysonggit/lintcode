class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     * key: finding sum of all ascending subsequences
     */
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int global_max = 0;
        for(int i=1; i<prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff>0) global_max += diff;
        }
        return global_max;
    }
};
