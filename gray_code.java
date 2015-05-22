public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0; i< (1<<n); i++){
            int gc = (i>>1) ^ i;
            res.add(gc);
        }
        return res;
    }
}

