// 09.19 DP问题
// corner case: amount = 0;
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && (dp[i - coins[j]] > 0 || i - coins[j] == 0)) {
                    if (dp[i] == 0) 
                        dp[i] = dp[i - coins[j]] + 1;
                    else
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > 0 ? dp[amount] : -1;
    }
}