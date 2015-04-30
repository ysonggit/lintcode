public class Solution {
    /**
     * @param s a string
     * @return an integer
     * C[i] : minimal cuts to make first i characters of s palindrome partitions
     * C[i] = 0 if s.substring(0, i) is a palindrome
     *      = min{ C[j]+1 } if s.substring(j, i) is a palindrome 
     *        j = 0 .. i-1
     * P[i][j] : s.substring(i,j+1) is a palindrome
     * 
     */
    boolean isPalindrome(String t){
        int n = t.length();
        if(n<=1) return true;
        int front=0, back=n-1;
        while(front<back){
            if(t.charAt(front)!= t.charAt(back)) return false;
            front++;
            back--;
        }
        return true;
    }
    public int minCut(String s) {
        int n = s.length();
        if(n==0) return 0;
        int C[] = new int[n+1];
        C[0]=0;
        C[1]=0;
        boolean P[][] = new boolean[n][n+1];
        for(int i=0; i<n; i++){
            P[i][i]=true;
        }
        for(int i=0; i<n; i++){
           for(int j=i+1; j<=n; j++){
               P[i][j] = isPalindrome(s.substring(i,j));
           }
        }
        for(int i=2; i<=n; i++){
            if(P[0][i]==true) C[i] = 0;
            else{
                int min_cuts = n+1;
                for(int k=0; k<i; k++){
                    if(P[k][i]==true){
                        min_cuts = Math.min(min_cuts, C[k]+1);
                    }
                }
                C[i] = min_cuts;
            }
        }
        return C[n];
    }
};

