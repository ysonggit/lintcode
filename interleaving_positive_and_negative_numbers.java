class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     * similar to partition array
     * 1. partition the array into two parts, left are negatives, right are positives
     * 2. swap strategy: 
     *    Even numbers (postives = negatives)
     *       [-1 -2 -3 1 2 3]  
     *       [3  -2 1 -3 2 -1]
     *    Odd numbers 
     *      could be postives < negatives
     *       [-1 -2 -3 1 2]
     *       [-1 2 -3 1 -2]
     *      or 
     *       [-1 -2 3 1 2]
     *       [1 -2 3 -1 2]
     */
    public void rerange(int[] A) {
        int n = A.length;
        if(n<2) return;
        int front = 0, back = n-1;
        while(front<back){
            while(front<=back && A[front]<0) front++;
            while(back>front && A[back]>0) back--;
            if(front<back && A[front]>0 && A[back]<0){
                int tmp = A[front];
                A[front] = A[back];
                A[back] = tmp;
            }
        }
        // so far, front is the index of first positive number
        int num_positives = n-front;
        int num_negatives = front;
        if(num_positives == num_negatives){
            front=0;
            back = n-1;
        }else if(num_positives< num_negatives){
            front = 1;
            back = n-1;
        }else{
            front = 0;
            back = n-2;
        }
        boolean exchange = true;
        while(front<back){
            if(exchange){
                int tmp = A[front];
                A[front] = A[back];
                A[back] = tmp;
            }
            exchange = exchange ? false : true;
            front++;
            back--;
        }
   }
}

