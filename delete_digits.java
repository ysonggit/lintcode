public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     * from pos 0 to A.size-1
     * find the longest non-decreasing subsequence , delete the last digit of this sequence
     * 178542
     * 178 so delete 8
     * 17542
     * 17 so delete 7 
     * and so on 
     */
    public String DeleteDigits(String A, int k) {
        int n = A.length();
        if(n==0 || k>=n) return new String();
        if(k==0){
            // mistake: remove leading 0s
            int j=0;
            while(j<n-1 && A.charAt(j)=='0') j++;
            return A.substring(j);
        }
        int i=1;
        while(i<n){
            if(A.charAt(i) - A.charAt(i-1)>=0) {// >= not >
                i++;
            }else{
                break;
            }
        }
        int pos_to_delete = i-1;
        StringBuilder B = new StringBuilder(A);
        B.deleteCharAt(pos_to_delete);
        return DeleteDigits(B.toString(), k-1);
    }
}

