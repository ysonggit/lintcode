public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        int [] count = new int [256];
        int max_len = 0;
        int front =0, back =0;
        while(back<n){
            char c = s.charAt(back);
            count[c]++;
            while(count[c]>1){
                // move front
                while(front<back){
                    count[s.charAt(front)]--; // mistake: if(s.charAt(front)==count[c]) count[c]--;
                    front++;                  // should reduce the count of every char pointed by front
                    if(count[c]==1) break;
                }
            }
            max_len = Math.max(max_len, back-front+1);
            back++;
        }
        return max_len;
    }
}
