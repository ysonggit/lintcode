class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     * # of trailing zeroes = # of 5 and 2 pairs
     *                      = # of 5s in prime factors of n!
     * mistake take care of overflow , c++ uses long long for count of 5s
     */
    public long trailingZeros(long n) {
        long count = 0;
        for(long i=5; i<=n; i*=5){
            count += n/i;
        }
        return count;
    }
};

