// @Author 黄xing
// Using the idea of merging sort to get the nth Ugly Number.
// The idear is that, we can divide the numbers into three sequence, although they can be dunplicated.
// 2 * (1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ...)
// 3 * (1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ...)
// 5 * (1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ...)
// set three pointer for each sequence, every time we pick the lowest one, then move to the next pointer.
public class Solution {
    public int nthUglyNumber(int n) {
        int point1 = 0;
        int point2 = 0;
        int point3 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int next = Math.min(Math.min(ugly[point1] * 2, ugly[point2] * 3), ugly[point3] * 5);
            if (next == ugly[point1] * 2) {
                point1++;
            }
            if (next == ugly[point2] * 3) {
                point2++;
            }
            if (next == ugly[point3] * 5) {
                point3++;
            }
            ugly[i] = next;
        }
        return ugly[n - 1];
    }
}