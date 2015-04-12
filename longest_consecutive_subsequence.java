public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if(num.length == 0) return 0;
        HashSet<Integer> hash = new HashSet<Integer>();
        for(int i: num){
            if(!hash.contains(i)) hash.add(i);        
        } 
        int max_len = 1;
        for(int i : num){
            int len = 1;
            int left = i-1;
            int right = i+1;
            while(hash.contains(left)){
                len++;
                hash.remove(left);
                left -= 1;
            }
            while(hash.contains(right)){
                len++;
                hash.remove(right);
                right += 1;
            }
            max_len = Math.max(max_len, len);
        }
        return max_len;
    }
}
