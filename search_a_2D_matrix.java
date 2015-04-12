public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n==0) return false;
        int m = matrix[0].length;
        int row = n -1;
        int col = 0;
        while(row>=0 && col<m){
            int cur = matrix[row][col];
            if(cur==target){
                return true;
            }
            if(cur>target){
                row--;
                if(row<0) return false;
            }
            if(cur<target){
                col++;
                if(col==m) return false;
            }
        }
        return false;
    }
}


