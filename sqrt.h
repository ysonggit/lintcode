class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     * binary search : x 
     */
    public int sqrt(int x) {
        if(x<0) return -1;
        if(x==0 || x==1) return x;
        int left = 1, right = x/2+1;
        while(left <= right){
            int mid = (left+right)/2;
            // if x/mid is in [mid, mid+1)
            if(x/mid >= mid && x/(mid+1) < (mid+1)){
                return mid;
            }
            if(x/mid < mid) right = mid-1;// mid is bigger, search left
            if(x/mid > mid) left = mid+1; // mid is smaller, search right
        }
        return 1;
    }
}
