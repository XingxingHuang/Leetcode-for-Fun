// python: https://discuss.leetcode.com/topic/93712/python-straightforward-with-explanation
// Sort all the courses by their ending time. When considering the first K courses, they all end before end. A necessary and sufficient condition for our schedule to be valid, is that (for all K), the courses we choose to take within the first K of them, have total duration less than end.
// For each K, we will greedily remove the largest-length course until the total duration start is <= end. To select these largest-length courses, we will use a max heap. start will maintain the loop invariant that it is the sum of the lengths of the courses we have currently taken.
// 按照结束的时间排序，依次添加课程，如果结束时间大于end，那么每次减去最长的那门课程。
// def scheduleCourse(self, A):
//     pq = []
//     start = 0
//     for t, end in sorted(A, key = lambda (t, end): end):
//         start += t
//         heapq.heappush(pq, -t)
//         while start > end:
//             start += heapq.heappop(pq)
//     return len(pq)


// https://discuss.leetcode.com/topic/93790/short-java-code-using-priorityqueue
public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) -> a[1] - b[1]); //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int time=0;
        for (int[] c : courses) {
            time += c[0]; // add current course to a priority queue
            pq.add(c[0]);
            if (time > c[1]) {
                time-=pq.poll(); //If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
            }
        }        
        return pq.size();
    }
}

// https://leetcode.com/contest/leetcode-weekly-contest-38/ranking/
// 小技巧，加入课程长度的负数
public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = courses.length;
        int s = 0;
        for(int i = 0;i < n;i++){
            int[] c = courses[i];
            s += c[0];
            pq.add(-c[0]);
            while(s > c[1]){
                s += pq.poll();
            }
        }
        return pq.size();
    }
}   