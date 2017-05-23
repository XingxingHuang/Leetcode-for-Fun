// http://www.lintcode.com/en/problem/house-robber/
// 典型滚动数组DP的题目
public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long cur = A[0];
        long last = 0;
        for (int i = 1; i < A.length; i++) {
            long tmp = cur;
            cur = Math.max(cur, last + A[i]);
            last = tmp;
        }
        return cur;
    }
}


public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long[] res = new long[n+1];
        
        
        res[0] = 0;
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + A[i-1]);
        }
        return res[n];
    }
}