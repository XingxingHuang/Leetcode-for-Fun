/**
 * http://www.lintcode.com/en/problem/coins-in-a-line-iii/
 * 做了前面的题目之后应该可以知道，从后往前推算的dp方法
 * dp[i][j]的含义为，剩余i-j的元素时，当前先手能拿到的最大值。
 * 注意画出矩形图，选择适当的填充方向。
 */
public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int[][] dp = new int[n + 1][n + 1];
        int[] sum1 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum1[i] = sum1[i - 1] + values[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            dp[i][i] = values[i - 1];  // 这个初始化不能放在下面第一重循环中
        }
        // 这里是错误代码，填充方法错误。
        // for (int i = 1; i <= n; i++) {
        //     for (int j = i + 1; j <= n; j++) {
        //         int sum = sum1[j] - sum1[i - 1]; // 元素第i - j的和, 
        //         dp[i][j] = Math.max(sum - dp[i + 1][j], sum - dp[i][j - 1]);
        //         System.out.println(" "+i+" "+j+" "+dp[i+1][j]+" "+dp[i][j-1]);
        //     }
        // }
        for (int len = 1; len < n; len++) {
            for (int i = 1; i <= n; i++) {
                int j = i + len;
                if (j > n) continue;
                int sum = sum1[j] - sum1[i - 1];
                dp[i][j] = Math.max(sum - dp[i + 1][j], sum - dp[i][j - 1]);
            }
        }
        return dp[1][n] > sum1[n] / 2;
    }
}

// 九章答案，包括记忆化搜索方法
// http://www.jiuzhang.com/solution/coins-in-a-line-iii/