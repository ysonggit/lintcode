public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(n==0) return digits;
        int carry = 1;
        for(int i=n-1; i>=0; i--){
            int d = digits[i];
            digits[i] = (d+carry)%10;
            carry = (d+carry)/10;
        }
        if(carry==0) return digits;
        int res [] = new int[n+1];
        System.arraycopy(digits, 0, res, 1, n);
        res[0]=1;
        return res;
    }
}
