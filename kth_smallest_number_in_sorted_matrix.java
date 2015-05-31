public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     * given a m-by-n matrix, find the k-th smallest number is equivalent to 
     * find
     * the (k-m)^th element in the submatrix by excluding the first col of original matrix
     * or 
     * the (k-n)^th element in the submatrix by excluding the first row of original matrix
     * 
     * base case: if k==1 return (sub)matrix[startrow][startcol]
     * if k< min(m, n), return min(matrix[0][k], matrix[k][0])
     *      Memory Limit Exceed for last test case
     */
    public int kthSmallest(int[][] matrix, int k) {
       int rows = matrix.length, cols = matrix[0].length;
       int startrow = 0, startcol = 0;
       while(startrow < rows && startcol < cols){
            int m = rows - startrow, n = cols - startcol;
            if(k<=n && k<=m) return Math.min(matrix[startrow][startcol+k-1], matrix[startrow+k-1][startcol]);
            if(k<=n) return matrix[startrow][startcol+k-1];
            if(k<=m) return matrix[startrow+k-1][startcol];
            if(matrix[startrow][cols-1] < matrix[rows-1][startcol]){
                k = k-n;
                startrow++; 
            }else{
                k = k-m;
                startcol++;
            }
       }
       return 0;
    }
}
