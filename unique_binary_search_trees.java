public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     * for each number i, if it is the root, (i=1...n)
     * the left subtree can be built by numbers [0..i-1]  // 0 means null 
     * the right subtree can be built by numbers [i+1..n]
     */
    HashMap<Integer, Integer> computed = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        if(computed.containsKey(n)) return computed.get(n);
        if(n<=1){
            computed.put(n,1);
            return 1;
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            count += numTrees(i-1) * numTrees(n-i);
        }
        computed.put(n, count);
        return count;
    }
}

