public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     * trivial solution O(n^2)
     * O(n) solution
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        if(n<1) return res;
        int start = 0, end = 0;
        res.add(start);
        res.add(end);
        int global_max = A[0], local_max = A[0];
        for(int i = 1; i<n; i++){
            local_max += A[i];   
            if(local_max < A[i] ){ // important! if all numbers are negative
                local_max = A[i]; 
                start=i;
            }
            if(global_max < local_max){
                global_max = local_max; 
                end = i;
                res.set(0, start);
                res.set(1, end);
            }
        }
        return res;
    }
}
