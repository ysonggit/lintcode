/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    class IntervalCmp implements Comparator<Interval>{
        public int compare (Interval a, Interval b){
            return a.start - b.start; // ascending order
        }
    }
    // For inputsL: a and b are sorted in ascending order
    public boolean overlap(Interval a, Interval b){
        return (a.end>= b.start);
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        int n = intervals.size();
        if(n==0) return res;
        Collections.sort(intervals, new IntervalCmp()); // nlogn
        res.add(intervals.get(0));
        for(int i=1; i<n; i++){
            Interval pre = res.get(res.size()-1);
            Interval cur = intervals.get(i);
            if(overlap(pre, cur)){
                res.get(res.size()-1).end = Math.max(pre.end, cur.end);
            }else{
                res.add(cur);
            }
        }
        return res;
    }

}

