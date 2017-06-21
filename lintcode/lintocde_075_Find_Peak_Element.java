// http://www.lintcode.com/en/problem/find-peak-element/
// 边界条件很容易出错，方向不要弄反了
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int l = 1;
        int r = A.length - 2;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (A[m] < A[m - 1]) {
                r = m;
            } else if (A[m] < A[m + 1]) {
                l = m;
            } else {
                return m;
            }
        }
        if (A[l] > A[r]) {
            return l;
        }
        return r;
    }
}
