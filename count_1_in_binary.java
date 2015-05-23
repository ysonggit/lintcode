public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int count = 0;
        while(num>0){
            num = num & (num-1);
            count++;
        }
        return count;
    }
};

