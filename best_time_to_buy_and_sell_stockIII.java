class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     * divide and conquer
     * before [i] : max profit gained before (including) day i
     * after [i] : max profit gained after (including) day i
     * 
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1) return 0;
        int [] before = new int[n];
        int [] after = new int[n];
        int min_price = prices[0];
        for(int i= 1; i<n; i++){
            int diff = prices[i] - min_price;
            before[i] = Math.max(before[i-1], diff);
            min_price = Math.min(prices[i], min_price);
        }
        int max_price = prices[n-1];
        for(int j=n-2; j>=0; j--){
            int diff = max_price - prices[j];
            after[j] = Math.max(after[j+1], diff);
            max_price = Math.max(prices[j], max_price);
        }
        int global_max = 0;
        for(int i=0; i<n-1; i++){
            global_max = Math.max(global_max, before[i]+after[i+1]);
        }
        return Math.max(global_max, before[n-1]);
    }
};
