public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        for(int i : A){
            minheap.add(i);
        }
        for(int i=0; i<A.length; i++){
            A[i] = minheap.poll();
        }
    }
}
