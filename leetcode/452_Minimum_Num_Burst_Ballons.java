/**
 * @Author: Xingxing Huang
 * @Time:
 * @Date: 2017.04.01
 * 注意考虑在sort的时候按照升序，还是降序排列对结果的影响
 * 每日一题结题答案：http://t.cn/R6lZvTk
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        //Arrays.sort(points, (x, y) -> (x[0] - y[0])); // ascend order
        Arrays.sort(points, new Comparator<int[]>() {
          public int compare(int[] a, int[] b) {
              return a[0] - b[0];
          }    
        });
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                // the point is outside the end
                end = points[i][1];
                count++;
            } else if (points[i][1] < end){
                // the point end before the "end"
                end = points[i][1];
            }
        }
        return count;
    }
}