class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) 
            return 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) 
            dp[i][i] = 1;
        for (int i = 1; i < n; ++i) {    // 表示间隔，从1开始到间隔n-1.
            for (int j = 0; j < n - i; ++j) { // 依次遍历每个元素
                dp[j][j + i] = i + 1;  
                for (int k = j + 1; k <= j + i; ++k) {  // 从该间隔中任意一点断开字符串。
                    int t = dp[j][k - 1] + dp[k][j + i];
                    if (s.charAt(k - 1) == s.charAt(j + i))  // 相同就可以省略依次打印次数。
                        --t;
                    dp[j][j + i] = Math.min(dp[j][j + i], t);
                }
            }
        }
        return dp[0][n - 1];
    }
}