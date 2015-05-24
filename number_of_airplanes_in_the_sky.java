/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     * Key idea: maintain a minheap of interval, ordered by the end time of the interval
     * [[1,10],[2,3],[5,8],[4,7]]
     * sort list: [1,10],[2,3],[4,7],[5,8]]
     * 1. cur = [1,10]
     *       [1,10]
     * 
     * 2. cur = [2,3]
     *       [2,3]
     *            \ 
     *           [1,10]
     * 
     * 3. cur = [4,7]
     *       [4,7]
     *           \
     *           [1,10]
     * 4. cur = [5,8]
     *       [4,7]
     *           \
     *          [5,8]
     *              \
     *             [1,10]
     * the heap top is the interval that has the earliest time, 
     * compare the top with other intervals see if they overlap
     * if yes, then insert that interval to minheap; 
     * otherwise, pop the heap until find one interval in the heap overlaps with current one, or until the heap is empty
     *            then, push current interval to the heap
     */
    class IntervalCmp implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            if(a.start == b.start) return a.end - b.end;
            return a.start - b.start;
        }
    }
    class MinHeapCmp implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.end - b.end;
        }
    }
    public int countOfAirplanes(List<Interval> airplanes) { 
        int n = airplanes.size();
        if(n<=1) return n;
        int count = 1;
        Collections.sort(airplanes, new IntervalCmp());
        PriorityQueue<Interval> minheap = new PriorityQueue<Interval>(n, new MinHeapCmp());
        for(int i=0; i<n; i++){
            Interval cur = airplanes.get(i);
            if(minheap.isEmpty() || cur.start < minheap.peek().end){
                minheap.offer(cur);
            }else{
                while(cur.start >= minheap.peek().end){
                    minheap.poll();
                    if(minheap.isEmpty()) break;
                }
                minheap.offer(cur);
            }
            count = Math.max(count, minheap.size());
        }
        return count;
    }
}

