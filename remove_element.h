public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if(A.length<1) return 0;
        int j=0;
        int i=0;
        while( i<A.length){
            if(A[i]!=elem){
               A[j]=A[i];
               j++;
            }
            i++;
        }
        return j;
    }
}

