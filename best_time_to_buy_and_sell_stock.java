public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int min_price = prices[0];
        int global_max = 0;
        for(int i=1; i<prices.length; i++){
            int diff = prices[i] - min_price;
            global_max = Math.max(global_max, diff);
            min_price = Math.min(min_price, prices[i]);
        }
        return global_max;
    }
}
