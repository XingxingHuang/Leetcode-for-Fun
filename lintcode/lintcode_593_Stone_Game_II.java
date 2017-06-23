//http://www.lintcode.com/en/problem/stone-game-ii/
// 成环的情况下，相当于多了一种计算。之前dp[i][j]表示剩余i和j之间的元素，但是现在可以反着得到环的另外一边。
// 与Stone Game I 完全相同的计算方法，只是将数组复制一边。
// 最后计算过程中在数组中挑出最小值。

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame2(int[] A) {
        // Write your code here
        if (A == null || A.length <= 1) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[2 * n][2 * n];
        int[] sum = new int[2 * n + 1];
        
        for (int i = 1; i <= 2 * n; i++) {
            sum[i] = sum[i - 1] + A[(i - 1) % n];
        }
        
        // 动态规划求解
        for (int len = 1; len <= n; len++) { // 这里只需要计算到n的长度即可
            for (int i = 0; i <= 2 * n && i + len < 2 * n; i++) { 
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                                dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                }
            }
        }
        // 求得最小值
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i][i + n - 1]);
        }
        return ans;
    }
}
// 九章答案
// http://www.jiuzhang.com/solution/stone-game-ii/
public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame2(int[] A) {
        // Write your code here
        int n = A.length;
        if (n <= 1)
            return 0;

        int[][] dp = new int[2 * n][2 * n];

        int[] sum = new int[2 * n + 1];

        for (int i = 1; i <= 2 * n; ++i) {
            sum[i] = sum[i - 1] + A[(i - 1) % n];
        }

        for (int i = 0; i < 2 * n; ++i) {
            dp[i][i] = 0;
        }

        for(int len = 2; len <= 2 * n; ++len)
            for(int i= 0;i < 2 * n && i + len - 1 < 2 * n; ++i) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    if (dp[i][k] + dp[k+1][j] + sum[j + 1] - sum[i] < dp[i][j])
                        dp[i][j] = dp[i][k] + dp[k+1][j] + sum[j + 1] - sum[i];
                }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i)
            if (dp[i][i + n - 1] < ans)
                ans = dp[i][i + n - 1];
        return ans;
        
    }
}

