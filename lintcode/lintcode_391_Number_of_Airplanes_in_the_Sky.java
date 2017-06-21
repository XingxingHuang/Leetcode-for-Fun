/**
 * http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
 * 注意Collections, Comparator的用法
 */
 
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Point {
    int val;
    int flag;
    Point (int val, int flag) {
        this.val = val;
        this.flag = flag;
    }
}

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        ArrayList<Point> points = new ArrayList<>();
        for (Interval in : airplanes) {
            points.add(new Point(in.start, 1));
            points.add(new Point(in.end, 0));
        }
        Collections.sort(points, PointComparator);
        int ans = 0;
        int count = 0;
        for (Point point : points) {
            if (point.flag == 1) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
    
    public static Comparator<Point> PointComparator = new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            if (p1.val == p2.val) {
                return p1.flag - p2.flag;
            } else {
                return p1.val - p2.val;
            }
        }
    };
}

