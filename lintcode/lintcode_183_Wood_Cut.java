// http://www.lintcode.com/en/problem/wood-cut/
// 看到longest等字眼，想到动态规划问题.
// 但是这题用的是二分法。最后的值是在1~max之间，用二分法解决。

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int n = L.length;
        // int[][] dp = new int[n][k];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, L[i]);
        }
        
        int l = 0; // 注意为0的情况。不能用valid判断，溢出。
        int u = max;
        while (l + 1 < u) {
            int mid = l + (u - l) / 2;
            if (valid(L, mid, k)) {
                l = mid;
            } else {
                u = mid;
            }
        }
        if (valid(L, u, k)) {
            return u;
        } 
        return l;
    }
    private boolean valid(int[] L, int m, int k) {
        int count = 0;
        for (int i = 0; i < L.length; i++) {
            count += L[i] / m;
        }
        return count >= k;
    }
}