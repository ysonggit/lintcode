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
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int i = 0; 
        boolean inserted = false;
        while (i < intervals.size()){
            Interval cur = intervals.get(i);
            if(newInterval.end<cur.start){
                result.add(newInterval);
                inserted = true;
                break;
            }else if(newInterval.start > cur.end){
                result.add(cur);
                i++;
            }else{
                // overlap
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
                i++;
            }
        }
        if(inserted){
            while(i<intervals.size()){
              result.add(intervals.get(i));
              i++;
            } 
        }else{
            result.add(newInterval);
        }
        return result;
    }
}
