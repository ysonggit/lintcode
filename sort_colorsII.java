class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     * idea move m = (2,3,...k) to the right
     * O(kn)
     */
    public void moveToRight(int[] colors, int m){
        int n = colors.length;
        if(n==0) return;
        int j =0;
        for(int i=0; i<n; i++){
            if(colors[i] !=m){
                colors[j] = colors[i];
                j++;
            }
        }
        while(j<n){
            colors[j] = m;
            j++;
        }
    }
    public void sortColors2(int[] colors, int k) {
        int n = colors.length;
        if(n==0 || k<2) return;
        for(int m=2; m<=k; m++){
            moveToRight(colors, m);
        }
    }
}

