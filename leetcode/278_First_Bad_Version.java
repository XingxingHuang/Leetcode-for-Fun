// @Author: 黄xing
// Time: O(log N)

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (!isBadVersion(n)) {
            return -1;
        }
        int i = 1;
        int j = n;
        while (i < j) {
            //int mid = i + (j - i) / 2;  // yes
            //int mid = (i + j) / 2;  // no 溢出
            //int mid = (i + j) >>> 1;  // yes
            //int mid = (i + j) >> 1;  // no 溢出
            int mid = i + ((j - i) >> 1); // yes  位移优先级低于加减
            //int mid = i + (j - i) >>> 1;  // no
            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}