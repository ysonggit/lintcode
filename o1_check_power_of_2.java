class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        while(n!=0){
            if(n==1) return true;
            if((n & 1) == 1) return false;
            n = n >> 1;
        }
        return false;
    }
};
