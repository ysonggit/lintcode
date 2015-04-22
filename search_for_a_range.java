public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> res  = new ArrayList<Integer>(Arrays.asList(-1, -1));
        int n = A.size();
        if(n==0) return res;
        int front = 0, back = n-1;
        while(front<=back){
            int mid=(front+back)/2;
            if(A.get(mid)== target){
                int low = mid, high = mid;
                while(low> front && A.get(low-1)==target) low--; // mistake donot compare A.get(low-1) with A.get(low)
                while(high< back && A.get(high+1)==target) high++;
                return new ArrayList<Integer>(Arrays.asList(low, high));
            }else if (A.get(mid) < target){
                front = mid+1;
            }else{
                back = mid-1;
            }
        }
        return res;
    }
}

