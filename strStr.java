class Solution {
    /**
     * Returns a index to the first occurrence of target in source, or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if(source==null || target==null) return -1;
        int n = source.length(), m = target.length();
        if(m==0) return 0;
        
        for(int i =0; i<n-m; i++){
            int count = 0;
            for(int j=0; j<m; j++){
                if(source.charAt(i+j) == target.charAt(j)){
                    count ++;
                }else{
                    break;
                }
                if(count==m) return i;
            }
        }
        return -1;
    }
}
