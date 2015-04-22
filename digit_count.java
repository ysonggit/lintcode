class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int count = 0;
        for(int i = 0; i<=n; i++){
            for(char c : String.valueOf(i).toCharArray()){
                if(c-'0' ==k) count++;
            }
        }
        return count;
    }
};


