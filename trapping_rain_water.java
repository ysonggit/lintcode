public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int n = heights.length;
        if(n==0) return 0;
        int maxleftbars[] = new int[n];
        int maxrightbars[] = new int[n];
        for(int i=1; i<n; i++){
            maxleftbars[i] = Math.max(maxleftbars[i-1], heights[i-1]); // mistake: heights[i]
        }
        for(int i=n-2; i>=0; i--){
            maxrightbars[i] = Math.max(maxrightbars[i+1], heights[i+1]);
        }
        int vol = 0;
        for(int i=1; i<n-1; i++){
            int cur_bar = heights[i];
            int min_bar = Math.min(maxleftbars[i], maxrightbars[i]);
            if(cur_bar >= min_bar) continue;
            vol += 1 * (min_bar - cur_bar);
        }
        return vol;
    }
}
