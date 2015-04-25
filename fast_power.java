class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     *  * similar to pow(x, n)
     * divide and conquer
     * (a^n) %b = (a^(n/2) % b * a^(n/2) % b) % b if n is even
     * overflow problem? YES, use long 
     * assume a is positive
     */
    public int fastPower(int a, int b, int n) {
        if(n==0) return 1%b; // mistake : return 1; 2^0 %1 = 0
        if(n==1) return a % b;
        long fuck = (long) fastPower(a, b, n/2); // mistake : overflow
        fuck *= fuck;
        fuck %= b; //important! otherwise overflow
        if(n%2==1){
            fuck *= (long) fastPower(a, b, 1);
        }
        fuck %= b; //important! directly return fuck%b causes overflow!
        return (int)fuck;
    }
};

