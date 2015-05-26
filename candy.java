public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     * Three-pass 
     * 1. from left to right, find the minimum candies left[i] for child[i] based on child[i-1]
     * 2. from right to left, find the minimum candies right[j] for child[j] based on child[j+1]
     * 3. for a child[k] its candies = Max of left[k] and right[k]
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n<2) return n;
        int left[] = new int [n];
        left[0]=1;
        for(int i=1; i<n; i++){
            left[i] = (ratings[i] > ratings[i-1]) ? left[i-1]+1 : 1;
        }
        int right[] = new int [n];
        right[n-1] = 1;
        for(int j=n-2; j>=0; j--){
            right[j] = (ratings[j] > ratings[j+1]) ? right[j+1]+1 : 1;
        }
        int total = 0;
        for(int k=0; k<n; k++){
            total += Math.max(left[k], right[k]);
        }
        return total;
    }
}

