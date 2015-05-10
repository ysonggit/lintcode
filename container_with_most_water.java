public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int n = heights.length;
        if(n<2) return 0;
        int front = 0, back=n-1;
        int max_vol = 0;
        while(front<back){
            int cur_vol = Math.min(heights[front], heights[back]) * (back-front);
            max_vol = Math.max(max_vol, cur_vol);
            if(heights[front] < heights[back]){
                front++;
            }else{
                back--;
            }
        }
        return max_vol;
    }
}
