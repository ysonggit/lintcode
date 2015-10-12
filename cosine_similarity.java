class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        double error = 2.0000;
        if(A.length!=B.length) return error;
        long sum_prod = 0, sum_sq_A = 0, sum_sq_B = 0;
        for(int i=0; i<A.length; i++){
            sum_prod += A[i] * B[i];
            sum_sq_A += A[i] * A[i];
            sum_sq_B += B[i] * B[i];
        }
        if(sum_sq_A==0 || sum_sq_B ==0) return error;
        if(sum_prod==0) return 0;
        return sum_prod/(Math.sqrt(sum_sq_A) * Math.sqrt(sum_sq_B));
    }
}

