public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     * see comments
     *
     */ 
    public int[] printZMatrix(int[][] matrix) {
    
        int m = matrix.length;
        if(m==0) return new int [0];
        int n = matrix[0].length;
        int i =0, j= 0;
        int res [] = new int [m*n];
        int k = 0;
        while(k < m * n){
            // At top row, move right by one step
            // exception, if reach last column, move down
            if(j<n-1){ res[k]= (matrix[i][j++]); k++;}
            else {res[k]=(matrix[i++][j]); k++;}
            
            //IMPORTANT ! 
            if(k==m*n) break;
            
            // keep on moving lower left until reach boarder
            while(i<m-1 && j>0){ res[k] = (matrix[i++][j--]); k++; }
            
            // At left col, move down by one step
            // exception : if reach last row, move right
            if(i<m-1){ res[k] = (matrix[i++][j]); k++;}
            else{ res[k] = (matrix[i][j++]); k++; }
            
            // keep on moving upper right until reach boarder
            while(i>0 && j<n-1) {
                res[k]=(matrix[i--][j++]);
                k++;
            }
        }
        return res;
    }
}

