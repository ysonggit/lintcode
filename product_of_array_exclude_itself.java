public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        int n = A.size();
        if(n<=1) return new ArrayList<Long>();
        ArrayList<Long> left_prod = new ArrayList<Long>();
        left_prod.add(Long.valueOf(1));
        left_prod.add(Long.valueOf(A.get(0)));
        ArrayList<Long> right_prod = new ArrayList<Long>();
        right_prod.add(Long.valueOf(A.get(n-1)));
        right_prod.add(Long.valueOf(1));
        for(int i=1; i<n; i++){
            left_prod.add(A.get(i) * left_prod.get(left_prod.size()-1));
        }
        for(int i=n-2; i>=0; i--){
            right_prod.add(0, A.get(i) * right_prod.get(0));
        }
        ArrayList<Long> prod = new ArrayList<Long>();
        for(int i=0; i<n; i++){
            prod.add(left_prod.get(i) * right_prod.get(i+1));
        }
        return prod;
    }
}

