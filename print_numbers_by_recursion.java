public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    // use char array to denote a number:
    // ['0','0','1'] ==> 1
    // ['1','2','3'] ==> 123
    public void dfs(List<Integer> res, char [] number, int cur_idx, int n){
        if(cur_idx == n-1){
            String s = String.valueOf(number);
            res.add(Integer.valueOf(s));
            return ;
        }
        for(char c='0'; c<='9'; c++){
            number[cur_idx+1]=c; // important!
            dfs(res, number, cur_idx+1, n);
        }
    }
     
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n==0) return res;
        char [] number = new char[n];
        Arrays.fill(number, '0');
        for(char i='0'; i<='9'; i++){
            number[0] = i;
            dfs(res, number, 0, n);
        }
        // res starts from 0
        res.remove(0); 
        return res;
    }
}

