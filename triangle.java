public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        if(n==0) return 0;
        ArrayList<Integer> pathsum = new ArrayList<Integer>();
        pathsum.add(triangle.get(0).get(0));
        for(int i=1; i<n; i++){
            ArrayList<Integer> lastsum = new ArrayList<Integer>(pathsum);
            pathsum.clear();
            ArrayList<Integer> cur_row = triangle.get(i);
            int m = cur_row.size();
            for(int j=0; j<m; j++){
                if(j==0){
                    pathsum.add(cur_row.get(j)+lastsum.get(j));
                }else if(j==m-1){
                    pathsum.add(cur_row.get(j)+lastsum.get(j-1));
                }else{
                    pathsum.add(Math.min(lastsum.get(j), lastsum.get(j-1)) + cur_row.get(j));
                }
            }
        }
        return Collections.min(pathsum);
    }
}


