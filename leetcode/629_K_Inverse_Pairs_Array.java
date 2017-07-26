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