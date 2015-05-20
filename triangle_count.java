public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        int n = S.length;
        if(n<3) return 0;
        int count = 0;
        Arrays.sort(S);
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(S[i]+S[j]>S[k]) count++;
                }
            }
        }
        return count;
    }
}
