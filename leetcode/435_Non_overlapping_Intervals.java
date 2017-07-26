/**
 * @Author: Xingxing Huang
 * @Time: O(N*log N)
 * @Date: 2017/04/01
 * Think how to count the overlap.
 * Think if one interval covers more than 1 intervals
 * Think if more intervals covers several intervals.
 * Solution: Sort and compare the start value to the end value.
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int end = intervals[0].end;
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            // when there is an overlap, renew the end to the minimum,
            // else move the end.
            if (intervals[i].start < end) {
                count++;
                end = Math.min(end, intervals[i].end);
            } else {
                end = intervals[i].end;
            }
        }
        return count;
    }
}
        
        
        
class myComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.end - b.end;
    }
}
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            // count the un overlap intervals
            if (intervals[i].start >= end) {
                count += 1;
                end = intervals[i].end;
            }
        }
        return intervals.length - count;
    }
}
