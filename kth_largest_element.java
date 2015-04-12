class MaxComparator implements Comparator<Integer>{
    public int compare(Integer x, Integer y){
        return y - x;
    }    
}

class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        int n = numbers.size();
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(n, new MaxComparator());
        for(Integer i : numbers){
            maxheap.add(i);
        }
        for(int i=1; i<k; i++){
            maxheap.poll();
        }
        return maxheap.peek();
    }
};
