/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     * make hashmap key integer
     */
    public int slope(Point a, Point b){
        if(a.x==b.x) return Integer.MAX_VALUE;
        return (int) (10000 * (a.y-b.y)/(double) (a.x-b.x));
    }
    public boolean samePoint(Point a, Point b){
        return a.x == b.x && a.y == b.y;
    }
    public int maxPoints(Point[] points) {
        if(points == null) return 0;
        int n = points.length;
        if(n<3) return n;
        int max_points = 2;
        for(int i=0; i<n; i++){
            Point a = points[i];
            HashMap<Integer, Integer> line_points = new HashMap<Integer, Integer>();
            int a_duplicates = 0;
            for(int j=i+1; j<n; j++){
                Point b = points[j];
                if(samePoint(a, b)){
                    a_duplicates++;
                }else{
                    int ab = slope(a, b);
                    if(line_points.containsKey(ab)){
                        line_points.put(ab, line_points.get(ab)+1);
                    }else{
                        // new line, 2 points
                        line_points.put(ab, 2);
                    }
                }
            }
            int max_points_inline_of_a = 1; // mistake: initial value should be 1 
            for(Map.Entry<Integer, Integer> entry : line_points.entrySet()){
                if(entry.getValue()> max_points_inline_of_a) {
                    max_points_inline_of_a = entry.getValue();
                }
            }    
            max_points_inline_of_a += a_duplicates;
            max_points = Math.max(max_points_inline_of_a, max_points);
        }
        
        return max_points;
    }
}
