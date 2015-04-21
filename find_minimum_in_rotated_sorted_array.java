public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int n = num.length;
        if(n==0) return 0;
        int front = 0, back = n-1;
        while(front<=back){
            if(front==back) return num[front];// [1]
            if(back-front==1) return Math.min(num[front], num[back]); //mistake [1,2]
            int mid = (front+back)/2;
            if(mid<back && num[mid] > num[mid+1]) return num[mid+1]; // [3 4 1 2]
            if(mid>front && num[mid] < num[mid-1]) return num[mid];// [4 1 2 3]
            if(num[mid]>num[back]){
                // search right half
                front = mid+1;
            }else{
                // search left half
                back = mid-1;
            }
        }
        return 0;
    }
}

