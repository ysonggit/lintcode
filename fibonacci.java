class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if(n==1) return 0;
        if(n==2) return 1;
        int f_n_2 = 0, f_n_1 = 1;
        int f_n = 0;
        for(int i=3; i<=n; i++){
            f_n = f_n_1 + f_n_2;
            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }
        return f_n;
    }
}

