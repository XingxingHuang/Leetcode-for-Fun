// 10.15  hard problem, practice next time
//  check solution for different methods
// https://leetcode.com/problems/erect-the-fence/solution/

// Approach #1 Jarvis Algorithm [Accepted]
// Approach #2 Graham Scan [Accepted]
// Approach #3 Monotone Chain [Accepted]

public class Solution {
    public int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }
    public List < Point > outerTrees(Point[] points) {
        Arrays.sort(points, new Comparator < Point > () {
            public int compare(Point p, Point q) {
                return q.x - p.x == 0 ? q.y - p.y : q.x - p.x;
            }
        });
        Stack < Point > hull = new Stack < > ();
        for (int i = 0; i < points.length; i++) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
                hull.pop();
            hull.push(points[i]);
        }
        hull.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
                hull.pop();
            hull.push(points[i]);
        }
        return new ArrayList < > (new HashSet < > (hull));
    }
}

