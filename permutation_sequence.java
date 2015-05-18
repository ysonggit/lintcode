class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      * Let the 4th permutation seq be : a1,a2,a3, then
      *      k1 = k = 3 (0 based)1 2 3
      * a1 = k1/(n-1)!  = 1  -->   *    (remove the number with index 1: 2)
      *      k2 = k1%(n-1)!=1    1 3
      * a2 = k2/(n-2)!  = 1  -->   *    (remove the number with index 1)
      *      k3 = k2%(n-2)!= 0   1  
      * a3 = k3/(n-3)!  = 0      *      
      */
    public int factorial(int n){
        if(n==1) return 1;
        return factorial(n-1) * n;
    }  
    public String getPermutation(int n, int k) {
      if(n<=0) return "";
      StringBuilder digits = new StringBuilder();
      for(int i=1; i<=n; i++){
          char c = (char) (i+(int)'0'); // in java, + works for int not char
          digits.append(c);
      }
      int fact = factorial(n);
      int kn = k-1; // 0 based 
      StringBuilder permu = new StringBuilder();
      while(n>0){
        fact = fact / n;
        int pos = kn / fact;
        kn = kn % fact;
        n--;
        permu.append(digits.charAt(pos));
        digits.deleteCharAt(pos);
      }
      return permu.toString();
    }
}
