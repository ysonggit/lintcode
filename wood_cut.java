public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     * 1. find the wood with maximum length
     * 2. binary search from [0, max_len]
     *    if count>=k, keep on increasing candidate length
     *    else reduce candidate length
     * failed cases: overflow , divided by zero
     */
    public int woodCut(int[] L, int k) {
        int n = L.length;
        if(n==0) return 0;
        if(n==1 && k!=0) return L[0]/k;
        int max_len = L[0];
        for(int i=1; i<n; i++){
            max_len = Math.max(max_len, L[i]);
        }
        int low =0; 
        int high = max_len;
        int longest = 0;
        while(low<=high){
            int mid = (high-low)/2+low; // mistake : do not use (low+high)/2 -> overflow
            if(mid==0) return 0; // mistake : special case 
            int count = 0;
            for(int len : L){
                count += len/mid;
            }
            if(count>=k){
                longest = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return longest;
    }
}

