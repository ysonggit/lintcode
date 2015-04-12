public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        if(A.length==0) return A;
        offset = offset % A.length;
        if(offset == 0) return A;
        int n = A.length;
        int count = 0;
        char temp[] = new char[offset];
        while (count < offset){
            temp[count] = A[n-offset+count];
            count++;
        }
        for(int i=n-1; i>=offset; i--){
            A[i] = A[i-offset];
        }
        for(int i=0; i<offset; i++){
            A[i] = temp[i];
        }
        return A;
    }
};
