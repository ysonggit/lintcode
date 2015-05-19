public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        if(m==0 && n==0) return "";
        if(m==0) return b;
        if(n==0) return a;
        int carry = 0;
        char sum[] = new char[Math.max(m, n)+1]; // using stringbuilder causes TLE
        int k = sum.length-1;
        int idxA = m-1, idxB=n-1;
        while(idxA>=0 || idxB>=0){
            int bitA = (idxA<0) ? 0 : (int) a.charAt(idxA)-'0';
            int bitB = (idxB<0) ? 0 : (int) b.charAt(idxB)-'0';
            char c = ((bitA+bitB+carry)%2 == 0) ? '0' : '1';
            carry = (bitA+bitB+carry)/2;
            sum[k]=c;
            idxA--;
            idxB--;
            k--;
        }
        if(carry>0) sum[0]= '1';
        String res = new String(sum);
        return (carry>0) ? res : res.substring(1);
    }
}

