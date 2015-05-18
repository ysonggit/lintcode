class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     * find the kth smallest 
     * key: maintains i+j=k
     * always have j = k-i
     */
    public double findKth(int[]A, int startA, int endA, int[]B, int startB, int endB, int k){
        int lenA = endA-startA+1;
        int lenB = endB-startB+1;
        if(lenA > lenB) return findKth(B, startB, endB, A, startA, endA, k);
        if(lenA==0) return B[k-1]; // kth smallest of B
        if(k==1) return Math.min(A[startA], B[startB]); // mistake A[0], B[0]
        int i = Math.min(k/2, lenA);
        int j = k-i;
        int Ai = A[startA+i-1];
        int Bj = B[startB+j-1];
        if(Ai<Bj) return findKth(A, startA+i, endA, B, startB, endB, k-i);
        if(Ai>Bj) return findKth(A, startA, endA, B, startB+j, endB, k-j);
        return Ai;
    }
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int total = m+n;
        if((total%2)==1) return findKth(A, 0, m-1, B, 0, n-1, total/2+1);
        return (findKth(A, 0, m-1, B, 0, n-1, total/2) + findKth(A, 0, m-1, B, 0, n-1, total/2+1) )/2.0;
    }
}


