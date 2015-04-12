class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     * clear bits j through i in N
     * shift M so it lines up with bits j through i
     * merge M and N
     */
    public int updateBits(int n, int m, int i, int j) {
        int l = j -i +1;
        int mask = (l==32) ? 0xffffffff : (1<<l)-1;
        int clear_n = n & ~(mask<<i);
        int shift_m = (m & mask)<<i;
        return clear_n | shift_m;
    }
}

