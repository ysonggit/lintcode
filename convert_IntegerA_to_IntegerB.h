class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     * 
    The bit operation which can be used to figure out which bits are different is xor.

    Each 1 in the xor will tell the different bit between the two integers.
     */
    public static int bitSwapRequired(int a, int b) {
       int count = 0;
       int c = a ^ b;
       while(c!=0){
          c= c & (c-1);
          count +=1; 
       }
       return count;
    }
};
