public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        int n = 32;
        int digits[] = new int [n];
        for(int i=0; i<A.length; i++){
            for(int k=0; k<n; k++){
                digits[k] += (A[i]>>k)&1;
            }
        }
        int num = 0;
        for(int j = 0; j<n; j++){
            num += (digits[j]%3)<<j;
        }
        return num;
    }
}
