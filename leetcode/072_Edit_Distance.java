// 递归->记忆化搜索->DP
// 2017.09.05
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
}

// 10.17
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 初始化
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) 
            dp[i][0] = i;
        for (int i = 1; i <= n; i++) 
            dp[0][i] = i;
        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // dp[i][j - 1]     + insert one
                // dp[i - 1][j]     + delete one
                // dp[i - 1][j - 1] + replace one
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}


// memorization method, 
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] mem = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) 
            for (int j = 0; j <= n; j++) 
                mem[i][j] = -1;
        return helper(word1, word2, m - 1, n - 1, mem);
    }
    private int helper(String word1, String word2, int i, int j, int[][] mem) {
        if (mem[i + 1][j + 1] == -1) {
            if (i == -1 && j == -1)
                mem[i + 1][j + 1] = 0;
            else if (i == -1)
                mem[i + 1][j + 1] = j + 1;
            else if (j == -1)
                mem[i + 1][j + 1] = i + 1;
            else {
                int min = Integer.MAX_VALUE;
                if (word1.charAt(i) == word2.charAt(j)) 
                    min = Math.min(min, helper(word1, word2, i - 1, j - 1, mem));
                min = Math.min(min, helper(word1, word2, i - 1, j, mem) + 1);
                min = Math.min(min, helper(word1, word2, i, j - 1, mem) + 1);
                min = Math.min(min, helper(word1, word2, i - 1, j - 1, mem) + 1);
                mem[i + 1][j + 1] = min;
            }
        }
        return mem[i + 1][j + 1];
    }
}