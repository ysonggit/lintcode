class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        int m = A.size(), n = B.size();
        ArrayList<Integer> C = new ArrayList<Integer>();
  
        int i = 0;
        int j = 0;
        while(i<m ||j<n){
            if(i==m){
                C.add(B.get(j++));
                continue;
            }
            else if(j==n){
                C.add(A.get(i++));
                continue;
            }
            else if(A.get(i) <= B.get(j) ){
                C.add(A.get(i++));
            }else{
                C.add(B.get(j++));
            }
        }
            
        return C;
    }
}
