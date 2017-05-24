// http://www.lintcode.com/en/problem/median-of-two-sorted-arrays/#
class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int m = A.length;
        int n = B.length;
        if ((m + n & 1) == 1) {
            return helper(A, 0, B, 0, (m + n) / 2 + 1);
        } else {
            return (helper(A, 0, B, 0, (m + n) / 2) + 
                    helper(A, 0, B, 0, (m + n) / 2 + 1)) / 2.;
        }
    }
    public int helper(int[] A, int m, int[] B, int n, int k) {
        // search for the kth element;
        if (m >= A.length) {
            return B[n + k - 1];
        }
        if (n >= B.length) {
            return A[m + k - 1];
        }
        // end situation;
        if (k == 1) {
            return Math.min(A[m], B[n]);
        }
        // mid value of two arrays.
        int mid_A = m + k/2 - 1 < A.length? A[m + k/2 - 1]: Integer.MAX_VALUE;
        int mid_B = n + k/2 - 1 < B.length? B[n + k/2 - 1]: Integer.MAX_VALUE;
        if (mid_A < mid_B) {
            return helper(A, m + k/2, B, n, k - k/2);
        } else {
            return helper(A, m, B, n + k/2, k - k/2);
        }
    }
}
