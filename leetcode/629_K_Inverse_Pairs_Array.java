// 2017.08.17  XingxingHuang
public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) 
            dp[i][0] = 1;
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i * (i - 1) / 2; j++) {
                if (j - i >= 0)
                    dp[i][j] = (dp[i][j - 1] + (dp[i - 1][j] + M - dp[i - 1][j - i]) % M) % M;
                else 
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % M;
            }
        }
        return dp[n][k];
    }
}


// 注意与上面的区别
public class Solution {
    public int kInversePairs(int n, int k) {
        int M = 1000000007;
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - i];
                if (j - i >= 0) 
                    dp[i][j] = (dp[i][j - 1] + (dp[i - 1][j] - dp[i - 1][j - i] + M) % M ) % M;
                else 
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % M;
            }
        }
        return dp[n][k];
    }
}

public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k && j <= i * (i - 1) / 2; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        return dp[n][k];
    }
}



// leetcode book : 
// https://leetcode.com/articles/k-inverse-pairs-array/


// https://leetcode.com/problems/k-inverse-pairs-array/#/solutions
// dp[n][k] the number of permutations of (1...n) with k inverse pairs.
// dp[n+1][k] = sum_{x=0..n} dp[n][k-x].
// 

// 这里是contest第一名的解法。空间优化之后的动态规划算法
public class Solution {
    public int kInversePairs(int n, int k) {
        long[] dp = new long[k+n+2];
        int mod = 1000000007;
        dp[0] = 1;
        for(int i = 1;i <= n;i++){
            for(int j = dp.length-1-i;j >= 0;j--){
                dp[j+i] -= dp[j];
                if(dp[j+i] < 0) dp[j+i] += mod;
            }
        }
        for(int i = 1;i <= n;i++){
            for(int j = 0;j < dp.length-1;j++){
                dp[j+1] += dp[j];
                dp[j+1] %= mod;
            }
        }
        return (int)dp[k];
    }
}