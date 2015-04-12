public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(n==0) return -1;
        int res[] = new int [n];
        int start_pos = 0, global = 0, local = 0;
        for(int i=0; i<n; i++){
            res[i] = gas[i] - cost[i];
            global += res[i];
            local += res[i];
            if(local<0){
                local = 0;
                start_pos = i+1;
            }
        }
        return global < 0 ?  -1 : start_pos;
    }
}

