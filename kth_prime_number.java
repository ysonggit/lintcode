class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     * Ugly numbers
     * DP: primes[i] : the i-th minimum prime number 
     * base primes[0] = 1
     * set 3 pointers a, b, c, initialize them as 0
     * primes[i] = min of primes[a] * 3, 
     *                    primes[b] * 5, 
     *                    primes[c] * 7
     * 
     * key : if primes[i] is from primes[a] , then a++, do similar operations on b, and c
     * here is the difficulty point: how to code ?
     */
    public long kthPrimeNumber(int k) {
        long primes[] = new long[k+1];
        primes[0]=1;
        int p3 =0, p5=0, p7=0;
        for(int i=1; i<=k; i++){
            primes[i] = Math.min(Math.min(primes[p3]*3, primes[p5]*5), primes[p7]*7);
            if(primes[i]/primes[p3]==3) p3++;
            if(primes[i]/primes[p5]==5) p5++;
            if(primes[i]/primes[p7]==7) p7++;
        }
        return primes[k];
    }
};


