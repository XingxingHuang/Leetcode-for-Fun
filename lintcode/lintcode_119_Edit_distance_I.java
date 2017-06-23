// http://www.lintcode.com/en/problem/edit-distance/#
// dp[i][j] 表示前面0~i, 0~j字符串最小的修改次数
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                } 
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
            }
        }
        return dp[m][n];
    }
}