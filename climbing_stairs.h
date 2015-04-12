public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if(n<=0) return 0;
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        cache.put(1,1);
        cache.put(2,2);
        if(n<=2) return cache.get(n);
        for(int i=3; i<=n; i++){
            cache.put(i, cache.get(i-1)+cache.get(i-2));
        }
        return cache.get(n);
    }
}
