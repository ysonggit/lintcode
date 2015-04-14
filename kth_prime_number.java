class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
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


