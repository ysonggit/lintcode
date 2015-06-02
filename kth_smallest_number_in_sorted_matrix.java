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
     * BUT, if you coding in cpp, with this idea, you can pass the online judge.
     * Since the cpp version has a reference parameter
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

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     * http://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
     * The idea is to use min heap. Following are detailed step.
        1) Build a min heap of elements from first row.
            A heap entry also stores row number and column number.
        2) Do following k times.
            a) Get minimum element (or root) from min heap.
            b) Find row number and column number of the minimum element.
            c) Replace root with the next element from same column and min-heapify the root.
        3) Return the last extracted root.
        [1 ,5 ,7]
        [3 ,7 ,8]
        [4 ,8 ,9]
        1) minheap 
                1
               / \
              5   7
        2) k=1
           a) extract root 1
           b) row 0, col 0
           c) root = 3
                    / \
                   5   7
           k=2
           a) extract root 3
           b) row 1, col 0
           c) root = 4
                    / \
                   5   7
           k=3
           a) extract root 4
           b) row 2, col 0
           c) root = 5
                    / \
                   7   7
           k=4
           a) extract root 5
           b) row 0, col 1
           c) root 7
                  / \
                 7   8
        3) return 5
     
     Memory Limit Exceed! QNMB!!! 
     
     */
    class Entry{
        int val, row, col;
        Entry(int v, int r, int c){
            val = v;
            row = r;
            col = c;
        }
    }
    class EntryCmp implements Comparator<Entry>{
        public int compare (Entry a, Entry b){
            return a.val - b.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(k<=0 || matrix.length==0) return 0;
        int n = matrix[0].length;
        PriorityQueue<Entry> minheap = new PriorityQueue<Entry>(n, new EntryCmp());
        for(int i=0; i<matrix[0].length; i++){
            minheap.offer(new Entry(matrix[0][i], 0, i));  
        }
        int popped_val = Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            Entry root = minheap.poll();
            popped_val = root.val;
            if(root.row < matrix.length-1){
                minheap.offer(new Entry(matrix[root.row+1][root.col], root.row+1, root.col));
            }
        }
        return popped_val;
    }
}
