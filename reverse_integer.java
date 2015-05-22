public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        if(n==0) return 0;
        int sign = (n>0) ? 1 : -1;
        n=Math.abs(n);
        int rev = 0;
        while(n>0){
            int rem = n % 10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && rem > Integer.MAX_VALUE%10)){
                return 0;
            }
            rev = rev * 10 + rem;
            n /= 10;
        }
        return sign * rev;
    }
}

