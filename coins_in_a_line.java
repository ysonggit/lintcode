public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     * XD
     * ALWAYS have :
     * n | Win ?
     * --|------
     * 0 | F
     * 1 | T
     * 2 | T
     * 3 | F
     * 4 | T
     * 5 | T
     * 6 | F
     * 7 | T
     * 
     */
    public boolean firstWillWin(int n) {
        return n % 3 != 0;
    }
}

