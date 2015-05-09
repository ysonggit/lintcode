public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if(n==0) return 0;
        int count[] = new int[256];
        int num_distinct = 0;
        int front=0, back=0;
        int max_len = 0;
        while(back<n){
            char c = s.charAt(back);
            if(count[c]==0) { num_distinct++; }
            count[c]++;
            while(num_distinct > k ){
                char f = s.charAt(front);
                count[f]--;
                if(count[f]==0) num_distinct--;
                front++;
            }
            max_len = Math.max(max_len, back-front+1);
            back++;
        }
        return max_len;
    }
}
