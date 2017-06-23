// http://www.lintcode.com/en/problem/edit-distance-ii/


public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // Write your code here
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1)
            return false;

        if (m > n)
            return isOneEditDistance(t, s);
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return m != n;
    }
}

// 超时
// public class Solution {
//     /**
//      * @param s a string
//      * @param t a string
//      * @return true if they are both one edit distance apart or false
//      */
//     public boolean isOneEditDistance(String s, String t) {
//         // Write your code here
//         int m = s.length();
//         int n = t.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 1; i <= m; i++) {
//             dp[i][0] = i;
//         }
//         for (int i = 1; i <= n; i++) {
//             dp[0][i] = i;
//         }
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
//                     dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]  + 1);
//                 }
//             }
//         }
//         return dp[m][n] == 1;
//     }
// }