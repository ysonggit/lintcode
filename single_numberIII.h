public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     * naive solution : sort array O(nlogn)
     * [1,2,3,4,2,4]
     * binary:
     * [0001, 0010, 0011, 1000, 0010, 1000]
     * 1). xor all elements : 0010
     * 2). the rightmost bit that is set to 1 in 0010 is
     *  0010
     * &1110
     * -----
     *  0010  <- rightmost mask
     * 3). mask the rightmost mask with each element
     * [0000, 0010, 0010, 0000, 0010, 0000]
     * in this set, only numbers in which the rightmost bit is set to 1 
     *                                  and the rightmost bit is set to 0
     * a=0, b=0
     * 4). use a and b to xor each_element in original array:
     * a:0001             1001        0001
     * b:     0010  0001        0011 
     */
    public List<Integer> singleNumberIII(int[] A) {
        List<Integer> res = new ArrayList<Integer>();
        if(A.length==0) return res;
        int xorset = A[0];
        for(int i=1; i<A.length; i++){
            xorset = xorset ^ A[i];
        }
        int rightmostmask = xorset & (~(xorset-1));
        int a = 0, b = 0;
        for(int i=0; i<A.length; i++){
            if((A[i] & rightmostmask)==0){
                a = a^A[i];
            }else{
                b = b^A[i];
            }
        }
        res.add(a);
        res.add(b);
        return res;
    }
}

